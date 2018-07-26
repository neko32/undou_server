package org.tanuneko.undou.api.controller

import javax.inject.{Inject, Named, Singleton}
import org.tanuneko.undou.tasks.{HELLO, MyTask}
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import org.slf4j.{LoggerFactory, MarkerFactory}

import scala.concurrent.duration._
import net.logstash.logback.argument.StructuredArguments._

@Singleton
class HealthCheckController @Inject()(
  @Named("my-task-actor") myTaskActor: ActorRef,
  override val controllerComponents: ControllerComponents
) extends BaseController
with DefaultImplicitExecutionContext
{

  implicit val timeout: Timeout = 5.seconds
  lazy val logger = LoggerFactory.getLogger(this.getClass)
  lazy val marker = MarkerFactory.getMarker("APP")

  def health: Action[AnyContent] = Action.async {
    (myTaskActor ? HELLO).mapTo[String].map { msg =>
      logger.info(marker, "hello called",
        keyValue("neko", "NYAN"),
        keyValue("abc", "alpha"),
        keyValue("endpoint", "healthCheck")
      )
      Ok(s"RESP - ${msg}")
    }
  }

}
