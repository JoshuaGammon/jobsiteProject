package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class TigerHire @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index())
  }

  def login = Action {
    Ok(views.html.login())
  }

  def newUser = Action {
    Ok(views.html.newUser())
  }

  def profile = Action {
    val name = "Mark Lewis"
    val pronouns = "He/Him"
    val bio = "Simulator of planetary rings, Scala zealot, avid roller skater, and general lover of programming and technology."
    val education = "PhD, Roller Derbying -- RollerCade University"

    Ok(views.html.profile(name, pronouns, bio, education))
  }

  def favorites = TODO

  def job = TODO

  def applicationPage = TODO

  def submitApplication = TODO

  def company = TODO

  def createJobPage = TODO

  def submitJobPosting = TODO

  def inbox = TODO

  def sendMessage = TODO

  def validateLogin = TODO

  def createNewUser = TODO

  def updateProfile = TODO
}
