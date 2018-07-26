package org.tanuneko.undou.tasks

import play.api.Logger

trait Starter {
  def doSome(): Unit
}

class StartupTasks extends Starter {

  override def doSome() = {
    Logger.info("Starting up server..")
  }
}
