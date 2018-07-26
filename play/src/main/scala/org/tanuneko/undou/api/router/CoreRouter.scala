package org.tanuneko.undou.api.router

import javax.inject.Inject
import org.tanuneko.undou.api.controller.{HealthCheckController, MarkController, PlayBackController}
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

import scala.concurrent.ExecutionContext

class CoreRouter @Inject()(
  healthCheckController: HealthCheckController,
  markController: MarkController,
  playBackController: PlayBackController
)(implicit ec: ExecutionContext) extends SimpleRouter {

  override def routes: Routes = {
    case GET(p"/health") => healthCheckController.health
    case GET(p"/mark") => markController.mark
    case GET(p"/play") => playBackController.play
  }
}
