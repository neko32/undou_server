package org.tanuneko.undou

import com.google.inject.AbstractModule
import org.tanuneko.undou.tasks._
import play.api.Logger
import play.api.libs.concurrent.AkkaGuiceSupport

class CoreModule extends AbstractModule with AkkaGuiceSupport {

  override def configure = {
    bindActor[MyTask]("my-task-actor")
    bindActor[PlaybackTask]("playback-actor")
    bind(classOf[PlaybackSchedulerTask]).asEagerSingleton
    bind(classOf[Starter]).to(classOf[StartupTasks]).asEagerSingleton
    Logger.info("GUICE Configuration done.")
  }
}
