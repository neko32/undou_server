package org.tanuneko.undou.api.controller

import javax.inject.{Inject, Singleton}
import org.tanuneko.undou.utils.MarkFileUtil
import play.api.Logger
import play.api.mvc.{BaseController, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class MarkController @Inject()(
  override val controllerComponents: ControllerComponents
)(implicit ec: ExecutionContext) extends BaseController {

  def mark = Action.async {
    Future {
      if(MarkFileUtil.markFileExists) {
        Logger.info(s"Marked as ${MarkFileUtil.markStr}")
        MarkFileUtil.mark
      } else {
        Logger.info(s"Markedfile will be created")
        MarkFileUtil.create
      }
      Ok
    }
  }

}
