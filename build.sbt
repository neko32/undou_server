import org.tanuneko.Dependencies._
import ProjectPluginKeys._

name := "undou_server"

version := "1.0"

scalaVersion := "2.12.6"

lazy val launchpadApp = (project in file("."))
  .aggregate(play)

lazy val play = project
  .enablePlay
  .settings(
    name := "morinoko",
    libraryDependencies ++= Seq(
      Aws.cloudwatchmetrics,
      Aws.dynamodb,
      Akka.akkaActor,
      Akka.akkaStream,
      Akka.akkaHttp,
      Akka.akkaTestkit,
      ehcache,
      guice,
      ws,
      Logstash.jsonEncoder,
      PlayJson.json,
      PlayTest.playtest
    )
  )

lazy val dockerSettings = Seq(
  dockerfile in docker := {
    val jarFile: File = sbt.Keys.`package`.in(Compile, packageBin).value
    val classpath = (managedClasspath in Compile).value
    val mainclass = mainClass.in(Compile, packageBin).value.getOrElse(sys.error("Expected eactly one main class"))
    val jarTarget = s"/app/${jarFile.getName}"
    val classpathString = classpath.files.map("/app/" + _.getName).mkString(":") + ":" + jarTarget
    new Dockerfile {
      from("openjdk:8-jre")
      add(classpath.files, "/app/")
      add(jarFile, jarTarget)
      expose(9000)
      entryPoint("java", "cp", classpathString, mainclass)
    }
  },
  imageNames in docker := Seq(
    ImageName("838276854355.dkr.ecr.us-east-1.amazonaws.com/morinoko")
  ),
  buildOptions in docker := BuildOptions(
    cache = false,
    removeIntermediateContainers = BuildOptions.Remove.Always,
    pullBaseImage = BuildOptions.Pull.Always
  )
)

addCommandAlias("run", "play/run")