name := "scala-playground"
ThisBuild / scalaVersion := "2.12.10"
ThisBuild / organization := "com.github.pawelhenek"

version := "0.0.1"

libraryDependencies ++= Seq()
scalacOptions in Test ++= Seq("-Yrangepos")

lazy val global = project
  .in(file("."))
  .aggregate(
      languagePlayground,
      finagleExample,
      akkaExample,
      flinkExample,
      sparkExample
  )

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val playJson = "com.typesafe.play" %% "play-json" % "2.6.9"
val specs2 = "org.specs2" %% "specs2-core" % "4.6.0"
val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.0"

lazy val languagePlayground = project
  .settings(
    name := "languagePlayground",
    libraryDependencies += playJson,
    libraryDependencies += specs2 % Test,
    libraryDependencies += scalaCheck % Test,
    libraryDependencies += scalaTest % Test
  )

val finagleHttp = "com.twitter" %% "finagle-http" % "19.11.0"

lazy val finagleExample = project
  .settings(
    name := "finagleExample",
    libraryDependencies += finagleHttp
  )

val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.5.13"
val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.5.13"
val akkaHttp = "com.typesafe.akka" %% "akka-http" % "10.1.3"

lazy val akkaExample = project
  .settings(
    name := "akkaExample",
    libraryDependencies += akkaActor,
    libraryDependencies += akkaStream,
    libraryDependencies += akkaHttp
  )

val flinkScala = "org.apache.flink" %% "flink-scala" % "1.9.1"
val flinkClients = "org.apache.flink" %% "flink-clients" % "1.9.1"
val flinkStreaming = "org.apache.flink" %% "flink-streaming-scala" % "1.9.1"

lazy val flinkExample = project
  .settings(
    name := "flinkExample",
    libraryDependencies += flinkScala,
    libraryDependencies += flinkClients,
    libraryDependencies += flinkStreaming
  )

lazy val sparkExample = project
  .settings(
    name := "sparkExample"
  )
