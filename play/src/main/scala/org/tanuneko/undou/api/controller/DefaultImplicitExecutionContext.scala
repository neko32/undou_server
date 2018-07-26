package org.tanuneko.undou.api.controller

import play.api.mvc.BaseControllerHelpers

import scala.concurrent.ExecutionContext

trait DefaultImplicitExecutionContext extends BaseControllerHelpers {

  implicit val executor: ExecutionContext = defaultExecutionContext

}
