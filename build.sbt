ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.github.pawelhenek"

version := "0.0.1"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.5.0"
val playJson = "com.typesafe.play" %% "play-json" % "2.6.9"

lazy val hello = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "scala-playground",
    libraryDependencies += playJson,
    libraryDependencies += scalaTest % Test
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello core",
    libraryDependencies ++= Seq(playJson, gigahorse),
    libraryDependencies += scalaTest % Test
  )