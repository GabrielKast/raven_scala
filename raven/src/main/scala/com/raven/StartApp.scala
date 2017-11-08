package com.raven

import akka.actor.{ ActorRef, ActorSystem }

import scala.util.{Success, Failure}
import scala.concurrent.{ ExecutionContext, Future }
import scala.concurrent.ExecutionContext.Implicits.global

import akka.event.Logging
import scala.concurrent.duration._
import scala.language.postfixOps

import scala.concurrent.Future
import akka.pattern.ask
import akka.util.Timeout

import com.raven.actors.Users
import com.raven.actors.Users.CreateUser
import com.raven.model.User


/**
 * Created by g on 08/11/17.
 */
//#main-class
object StartApp extends App {
  // Create the 'helloAkka' actor system
  implicit val system: ActorSystem = ActorSystem("ravenAkka")

  try {
    //#create-actors
    // Create the users actor
    implicit val duration: Timeout = 20 seconds
    val users: ActorRef = system.actorOf(Users.props, "usersActor")
    val user: Future[User] = (users ? CreateUser(User.create("Gabriel", "Kastenbaum"))).mapTo[User]
    user.onComplete {
      case Success(u) => println(u)
      case Failure(e) => println("Error!! $e")
    }

  } finally {
    system.terminate()
  }
}

//#main-class
