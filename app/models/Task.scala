package models

import java.sql.Connection

import play.api.db._
import play.api.Application
import anorm._
import anorm._
import anorm.SqlParser._
import anorm.SQL
import javax.inject.Inject
import play.api.db.Database
import play.api.mvc.ControllerComponents

case class Task (
                  id: Long,
                  label: String
                )


object Task {


  val task = {
    get[Long]("id") ~
      get[String]("label") map {
      case id~label => Task(id, label)
    }
  }

}