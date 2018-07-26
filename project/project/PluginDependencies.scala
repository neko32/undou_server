package org.tanuneko

import sbt._

object PluginDependencies {

  val play: ModuleID = "com.typesafe.play" % "sbt-plugin" % "2.6.13"
  val sbtDocker: ModuleID = "se.marcuslonnberg" % "sbt-docker" % "1.5.0"

}
