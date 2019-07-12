/*
 * Copyright 2019 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortysevendeg.hood.github

import cats.Functor
import cats.effect.Sync
import github4s.GithubResponses.GHException
import github4s.Github
import github4s.Github._
import github4s.cats.effect.jvm.Implicits._
import cats.implicits._
import io.chrisdavenport.log4cats.Logger

trait GithubService[F[_]] {

  type GithubPublishResult = Either[GHException, Unit]

  def publishComment(
      accessToken: String,
      owner: String,
      repository: String,
      pullRequestNumber: Int,
      comment: String): F[GithubPublishResult]

}

object GithubService {

  def build[F[_]](implicit S: Sync[F], L: Logger[F]): GithubService[F] = new GithubServiceImpl[F]

  class GithubServiceImpl[F[_]: Sync: Functor](implicit L: Logger[F]) extends GithubService[F] {

    def publishComment(
        accessToken: String,
        owner: String,
        repository: String,
        pullRequestNumber: Int,
        comment: String): F[GithubPublishResult] = {

      for {
        result <- Github(Some(accessToken)).issues
          .createComment(owner, repository, pullRequestNumber, comment)
          .exec()
          .onError { case e => L.error(e)("Found error while accessing GitHub API.") }
          .map { _ =>
            Right(())
          }
        _ <- L.info("Comment sent to GitHub successfully.")
      } yield result
    }

  }

}
