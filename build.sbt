name := "scala-playground"
ThisBuild / scalaVersion := "2.12.10"
ThisBuild / organization := "com.github.pawelhenek"

version := "0.0.1"

libraryDependencies ++= Seq()
scalacOptions in Test ++= Seq("-Yrangepos")

resolvers += "REPO MAVEN CENTRAL" at "https://repo1.maven.org/maven2"

lazy val global = project
  .in(file("."))
  .aggregate(
      languagePlayground,
      finagleExamples,
      akkaExamples,
      flinkExamples,
      sparkExamples,
      macwireExamples,
      gatlingExamples,
      alpakkaExamples
  )

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

val alpakkaFile = "com.lightbend.akka" %% "akka-stream-alpakka-file" % "1.1.2"
val alpakkaFtp = "com.lightbend.akka" %% "akka-stream-alpakka-ftp" % "1.1.2"

val akkaSlf4j = "com.typesafe.akka"  %% "akka-slf4j" % "2.5.13"

val apacheFtpServerCore = "org.apache.ftpserver" % "ftpserver-core" % "1.1.1"
val apacheFtpServer = "org.apache.ftpserver" % "ftpserver" % "1.1.1"

val googleJimfs = "com.google.jimfs" % "jimfs" % "1.1"

val sshd = "org.apache.sshd" % "sshd" % "1.7.0"
val sshdCore = "org.apache.sshd" % "sshd-core" % "1.7.0"

val akkaKafka = "com.typesafe.akka" %% "akka-stream-kafka" % "1.1.0"

lazy val alpakkaExamples = project
  .settings(
    name := "alpakkaExamples",
    libraryDependencies += alpakkaFile,
    libraryDependencies += alpakkaFtp,
    libraryDependencies += apacheFtpServer,
    libraryDependencies += apacheFtpServerCore,
    libraryDependencies += googleJimfs,
    libraryDependencies += sshd,
    libraryDependencies += sshdCore,
    libraryDependencies += scalaTest % Test,
    libraryDependencies += akkaKafka % Test,
    libraryDependencies += akkaActor,
    libraryDependencies += akkaSlf4j
  )

val gatlingCharts = "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1" % Test
val gatlingTest = "io.gatling" % "gatling-test-framework" % "3.3.1" % Test

lazy val gatlingExamples = project
  .settings(
    name := "gatlingExamples",
    libraryDependencies += gatlingCharts,
    libraryDependencies += gatlingTest
  )
  .enablePlugins(GatlingPlugin)


val playJson = "com.typesafe.play" %% "play-json" % "2.6.9"
val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.0"

lazy val languagePlayground = project
  .settings(
    name := "languagePlayground",
    libraryDependencies += playJson,
    libraryDependencies += scalaCheck % Test,
    libraryDependencies += scalaTest % Test
  )

val finagleHttp = "com.twitter" %% "finagle-http" % "19.11.0"

lazy val finagleExamples = project
  .settings(
    name := "finagleExamples",
    libraryDependencies += finagleHttp
  )

val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.5.13"
val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.5.13"
val akkaHttp = "com.typesafe.akka" %% "akka-http" % "10.1.3"

lazy val akkaExamples = project
  .settings(
    name := "akkaExamples",
    libraryDependencies += akkaActor,
    libraryDependencies += akkaStream,
    libraryDependencies += akkaHttp
  )

val flinkScala = "org.apache.flink" %% "flink-scala" % "1.9.1"
val flinkClients = "org.apache.flink" %% "flink-clients" % "1.9.1"
val flinkStreaming = "org.apache.flink" %% "flink-streaming-scala" % "1.9.1"

lazy val flinkExamples = project
  .settings(
    name := "flinkExamples",
    libraryDependencies += flinkScala,
    libraryDependencies += flinkClients,
    libraryDependencies += flinkStreaming
  )

val sparkCore = "org.apache.spark" %% "spark-core" % "2.4.4"
val sparkSql = "org.apache.spark" %% "spark-sql" % "2.4.4"

lazy val sparkExamples = project
  .settings(
    name := "sparkExamples",
    libraryDependencies += sparkCore,
    libraryDependencies += sparkSql
  )

val macwireMacros = "com.softwaremill.macwire" %% "macros" % "2.3.3"
val specs2 = "org.specs2" %% "specs2-core" % "4.8.1" % Test

lazy val macwireExamples = project
  .settings(
    name := "macwireExamples",
    libraryDependencies += macwireMacros,
    libraryDependencies += specs2
  )
