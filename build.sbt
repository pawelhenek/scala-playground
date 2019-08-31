ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.github.pawelhenek"

version := "0.0.1"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val playJson = "com.typesafe.play" %% "play-json" % "2.6.9"
val specs2 = "org.specs2" %% "specs2-core" % "4.6.0"
val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.0"

libraryDependencies ++= Seq()

scalacOptions in Test ++= Seq("-Yrangepos")

lazy val hello = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "scala-playground",
    libraryDependencies += playJson,
    libraryDependencies += specs2 % Test,
    libraryDependencies += scalaCheck % Test,
    libraryDependencies += scalaTest % Test
  )
