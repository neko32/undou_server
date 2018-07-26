package org.tanuneko.undou.tasks

import akka.actor.Actor
import javax.inject.Inject
import play.api.Configuration

class MyTask @Inject()(
  configuration: Configuration
) extends Actor {

  def receive = {
    case HELLO =>
      val msg = configuration.getOptional[String]("myactor.custom.message").getOrElse("N/A")
      sender ! msg
  }
}
