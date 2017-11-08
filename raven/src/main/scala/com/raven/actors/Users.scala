package com.raven.actors

import java.util.UUID

import akka.actor.{ActorRef, Actor, ActorLogging, Props}
import com.raven.model._
import scala.collection.immutable.Map

/**
 * Created by g on 08/11/17.
 */
object Users {
  //#users-messages
  def props: Props = Props[Users]
  //#users-messages
  final case class CreateUser(user: User)
  final case class GetUser(id: UUID)
}

class Users extends Actor with ActorLogging {
  import Users._
  var users : Map[UUID, User] = Map()

  def receive = {
    case CreateUser(user: User) =>
      val newUser = user.copy(id=UUID.randomUUID())
      users += (newUser.id -> newUser)
      sender() ! newUser
    case GetUser(id: UUID) =>
       sender() ! users.get(id)
  }
}