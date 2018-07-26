
import sbt._
import sbt.Keys._

object ProjectPluginKeys {

  implicit final class PlayOps(val p: Project) extends AnyVal {
    import play.sbt._
    import PlayImport.PlayKeys
    import play.twirl.sbt.Import.TwirlKeys

    def enablePlay: Project =
      p.enablePlugins(PlayScala)
      .disablePlugins(PlayLayoutPlugin)
      .settings(
        scalacOptions -= "-Ywarn-unused-import",
        PlayKeys.playMonitoredFiles ++=
          (sourceDirectories in (Compile, TwirlKeys.compileTemplates)).value
      )
  }


}
