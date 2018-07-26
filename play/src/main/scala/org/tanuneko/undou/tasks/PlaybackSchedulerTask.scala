package org.tanuneko.undou.tasks

import akka.actor.{Actor, ActorRef, ActorSystem}
import javax.inject.{Inject, Named}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class PlaybackSchedulerTask @Inject()(
  actorSys: ActorSystem,
  @Named("playback-actor") playback: ActorRef
)(implicit ec: ExecutionContext)
{
  actorSys.scheduler.schedule(
    initialDelay = 1.minutes,
    interval = 1.minutes,
    receiver = playback,
    message = PLAYBACK
  )

  actorSys.scheduler.schedule(
    initialDelay = 30.seconds,
    interval = 1.minutes,
    receiver = playback,
    message = RESETMARKFILE
  )
}
