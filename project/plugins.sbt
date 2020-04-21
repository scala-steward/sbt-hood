addSbtPlugin("com.47deg"                 % "sbt-microsites"    % "1.2.0")
addSbtPlugin("com.eed3si9n"              % "sbt-buildinfo"     % "0.9.0")
addSbtPlugin("com.geirsson"              % "sbt-ci-release"    % "1.5.3")
addSbtPlugin("pl.project13.scala"        % "sbt-jmh"           % "0.3.7")
addSbtPlugin("com.timushev.sbt"          % "sbt-updates"       % "0.5.0")
addSbtPlugin("org.scalameta"             % "sbt-scalafmt"      % "2.3.4")
addSbtPlugin("org.scoverage"             % "sbt-scoverage"     % "1.6.1")
addSbtPlugin("org.scalameta"             % "sbt-mdoc"          % "2.1.5")
addSbtPlugin("de.heikoseeberger"         % "sbt-header"        % "5.4.0")
addSbtPlugin("com.alejandrohdezma"       %% "sbt-github"       % "0.6.0")
addSbtPlugin("com.alejandrohdezma"       % "sbt-github-header" % "0.6.0")
addSbtPlugin("com.alejandrohdezma"       % "sbt-github-mdoc"   % "0.6.0")
addSbtPlugin("com.alejandrohdezma"       % "sbt-mdoc-toc"      % "0.2")
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"      % "0.1.11")

libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value
