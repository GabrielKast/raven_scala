package com.raven.model

import java.util.UUID

/**
 * Created by g on 08/11/17.
 */
case class User(id: UUID, firstname:String, lastname:String)

object User{
  def create (firstname:String, lastname:String) = User(UUID.randomUUID(), firstname, lastname)
}