package org.tanuneko.undou.api.controller

import java.awt.Desktop
import java.net.URI

import akka.actor.ActorSystem
import javax.inject.{Inject, Singleton}
import org.tanuneko.undou.utils.{MarkFileUtil, YoutubeUtil}
import play.api.Logger
import play.api.mvc.{BaseController, ControllerComponents}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

@Singleton
class PlayBackController @Inject()(
  actorSys: ActorSystem,
  override val controllerComponents: ControllerComponents
)(implicit ec: ExecutionContext) extends BaseController {

  def play = Action {
    if(!MarkFileUtil.markFileExists) {
      MarkFileUtil.create
    }
    MarkFileUtil.mark
    Logger.info(s"Marked as ${MarkFileUtil.markStr}")
    Redirect(YoutubeUtil.taisoUrl)
    implicit val ec: ExecutionContext = actorSys.dispatcher
    actorSys.scheduler.scheduleOnce(400 seconds) {
      Desktop.getDesktop.browse(new URI(YoutubeUtil.exerciseUrl))
    }
    Redirect(YoutubeUtil.taisoUrl)
  }
}
