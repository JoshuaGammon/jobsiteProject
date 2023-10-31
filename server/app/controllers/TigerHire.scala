package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def login = Action {
    Ok(views.html.login())
  }

  def newUser = Action {
    Ok(views.html.newUser())
  }

  def profile = ???

  def favorites = ???

  def job = ???

  def applicationPage = ???

  def submitApplication = ???

  def company = ???

  def createJobPage = ???

  def submitJobPosting = ???

  def inbox = ???

  def sendMessage = ???
}
