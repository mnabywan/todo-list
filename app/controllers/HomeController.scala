package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Task
import repositories.TaskRepository
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(taskService: TaskRepository, cc: ControllerComponents) extends AbstractController(cc)  with play.api.i18n.I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok("Hello! Go to /tasks to use application")
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )


  def about = Action{
    Ok("Created by Mateusz")
  }

  def hello(name: String) = Action{
    Ok("Hello "+ name)
  }

  def tasks() = Action{ implicit  request =>
    Ok(views.html.index(taskService.all(), taskForm))
  }

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(taskService.all(), errors)),
      name => {
        taskService.create(name)
        Redirect(routes.HomeController.tasks)
      }
    )
  }


  def deleteTask(id: Long) = Action {
    taskService.delete(id)
    Redirect(routes.HomeController.tasks)
  }
}
