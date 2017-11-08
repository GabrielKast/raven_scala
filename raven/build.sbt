name := "raven"

version := "0.1"

lazy val akkaHttpVersion = "10.0.10"
// lazy val akkaVersion    = "2.5.6"
lazy val akkaVersion    = "2.4.19"

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation", "-feature")

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.raven",
      scalaVersion    := "2.12.4"
    )),
    name := "akka-http-quickstart-scala",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor"           % akkaVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % "3.0.1"         % Test
    )
  )

