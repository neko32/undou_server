package org.tanuneko

import sbt._

object Dependencies {

  val scalacheck: ModuleID = "org.scalacheck" %% "scalacheck" % "1.13.5"

  object Aws {
    private val version = "1.11.256"
    val dynamodb: ModuleID = "com.amazonaws" % "aws-java-sdk-dynamodb" % version
    val cloudwatchmetrics: ModuleID = "com.amazonaws" % "aws-java-sdk-cloudwatchmetrics" % version
  }

  object AwsV2 {
    private val version = "2.0.0-preview-8"
    val core: ModuleID = "software.amazon.awssdk" % "core" % version
    val kinesis: ModuleID = "software.amazon.awssdk" % "kinesis" % version
  }

  object Akka {
    private val version = "2.5.12"
    val akkaActor: ModuleID = "com.typesafe.akka" %% "akka-actor" % version
    val akkaStream: ModuleID = "com.typesafe.akka" %% "akka-stream" % version
    val akkaHttp: ModuleID = "com.typesafe.akka" %% "akka-http" % "10.0.9"
    val akkaTestkit: ModuleID = "com.typesafe.akka" %% "akka-testkit" % version
  }

  object Logstash {
    val jsonEncoder: ModuleID = "net.logstash.logback" % "logstash-logback-encoder" % "5.1"
  }

  object PlayJson {
    val json: ModuleID = "com.typesafe.play" %% "play-json" % "2.6.9"
  }

  object PlayTest {
    val playtest: ModuleID = "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % "test"
  }
}
