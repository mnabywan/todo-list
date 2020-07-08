package models

import play.api.db.DBApi
import play.db.DBApi
import play.db.Database
import play.db._
import anorm.SqlParser._
import anorm._
import play.api.db.Database


case class Task(
  id: Long,
  label: String
)



object Task {

  def all(): List[Task] = Nil

  def create(label: String){}

  def delete(id: Long) {}

}