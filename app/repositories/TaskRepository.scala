package repositories

import javax.inject.Inject
import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.db.DBApi
import models.Task

@javax.inject.Singleton
class TaskRepository @Inject()(database: Database)(implicit ec: ExecutionContext) {

  val DB = database

  val task: RowParser[Task] = {
    get[Long]("id") ~
      get[String]("label") map {
      case id ~ label => Task(id, label)
    }
  }

  def all(): List[Task] = database.withConnection { implicit c =>
    SQL("select * from task").as(task *)
  }

  def create(label: String) {
    DB.withConnection { implicit c =>
      SQL("insert into task(label) values({label})").
        on('label -> label).
        executeUpdate()
    }
  }

  def delete(id: Long): Unit = {
    DB.withConnection { implicit c =>
      SQL("delete from task where id = {id}").
        on('id -> id).
        executeUpdate()
    }
  }
}

