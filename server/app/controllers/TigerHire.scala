package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.data._ 
import play.api.data.Forms._
import models.TigerHireModel

case class LoginData(username: String, password: String)

@Singleton
class TigerHire @Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {

  def index = Action {
    Ok(views.html.index())
  }

  val loginForm = Form(mapping(
    "Username" -> text(3, 10), 
    "Password" -> text(8)
    )(LoginData.apply)(LoginData.unapply))

  def login = Action { implicit request =>
    Ok(views.html.login(loginForm))
  }

  def validateLoginGet(username: String, password: String) = Action {
    Ok(s"$username logged in with $password.")
  }

  def validateLoginPost = Action { implicit request => 
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head 
      val password = args("password").head 
      if(models.TigerHireModel.validateUser(username,password)) {
        Redirect(routes.TigerHire.jobPostList).withSession("username" -> username)
      } else {
        Redirect(routes.TigerHire.login).flashing("error" -> "Invalid username/password combination.")
      }
    }.getOrElse(Redirect(routes.TigerHire.login))
  }

  def validateLoginForm = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithError => BadRequest(views.html.login(formWithError)),
      ld => 
        if(models.TigerHireModel.validateUser(ld.username,ld.password)) {
        Redirect(routes.TigerHire.profile).withSession("username" -> ld.username)
        } else {
        Redirect(routes.TigerHire.login).flashing("error" -> "Invalid username/password combination.")
        }
    )
  }

  
  def newUser = Action { implicit request => 
    val postVals = request.body.asFormUrlEncoded
    postVals.map {args =>
      val username = args("username").head
      val password = args("password").head
      if(models.TigerHireModel.createUser(username, password)){
        Redirect(routes.TigerHire.createNewUser).withSession("username" -> username)
      }
      else {
        Redirect(routes.TigerHire.login).flashing("error" ->"User creation failed.")
      }
      
    }.getOrElse(Redirect(routes.TigerHire.login))
  }

  def createUser = Action { implicit request => 
        val postVals = request.body.asFormUrlEncoded
        postVals.map { args =>
          val username = args("username").head 
          val password = args("password").head 
          if(models.TigerHireModel.createUser(username,password)) {
            Redirect(routes.TigerHire.profile).withSession("username" -> username)
          } else {
            Redirect(routes.TigerHire.login).flashing("error" -> "User creation failed.")
          }
        }.getOrElse(Redirect(routes.TigerHire.login))
  }

  def jobPostList = Action { implicit request =>
        val usernameOption = request.session.get("username")
        usernameOption.map { username =>
            val jobPosts = models.TigerHireModel.getJobPost(username)
            Ok(views.html.home(jobPosts))
        }.getOrElse(Redirect(routes.TigerHire.login))
    }

  
  def profile = Action {
    Ok(views.html.profile())
  }

  def favorites = TODO

  def job = TODO

  /*
  def home = Action {
    Ok(views.html.home())
  }
  */

  def applicationPage = TODO

  def submitApplication = TODO

  def company = TODO

  def createJobPage = TODO

  def submitJobPosting = TODO

  def inbox = TODO

  def sendMessage = TODO

  //def validateLogin = TODO

  def createNewUser = Action { 
    Ok(views.html.newUser()) 
  }

  def updateProfile = TODO
}
