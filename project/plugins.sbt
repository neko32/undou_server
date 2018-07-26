import org.tanuneko.PluginDependencies._

ivyLoggingLevel := UpdateLogging.Default
scalacOptions in Compile ++= Seq("-feature", "-deprecation")

addSbtPlugin(play)
addSbtPlugin(sbtDocker)