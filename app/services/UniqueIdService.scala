package services

import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout
import services.actors.UniqueIdActor
import services.actors.UniqueIdActor.NextId

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._

object UniqueIdService {
  private val system = ActorSystem("MySystem")
  private val idManagerActor = system.actorOf(UniqueIdActor.props)

  def getNextId(idKey: String)(implicit ec: ExecutionContext): Future[Int] = {
    implicit val timeout = Timeout(1 second)
    (idManagerActor ? NextId(idKey)) map { _.asInstanceOf[Int] }
  }
}
