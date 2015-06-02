package services.actors

import akka.actor.{Props, Actor}

class UniqueIdActor extends Actor {
  import services.actors.UniqueIdActor._

  private var nextIds: Map[String, Int] = Map()

  def receive = {
    case NextId(idKey) =>
      val id = nextIds.getOrElse(idKey, 1)
      nextIds = nextIds + (idKey -> (id + 1))
      sender() ! id
  }
}

object UniqueIdActor {
  val props = Props(new UniqueIdActor)

  case class NextId(idKey: String)
}
