package controllers

import play.api._
import play.api.cache.{Cache}
import play.api.libs.json.Json
import play.api.mvc._
import play.api.Play.current
import services.UniqueIdService

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Application extends Controller {

  def incrementId(idKey: String) = Action.async {
    UniqueIdService.getNextId(idKey) map { id =>
      Ok(
        Json.obj(
          "result" -> id
        )
      )
    }

  }

}
