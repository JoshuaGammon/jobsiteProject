package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._
import play.api.data._ 
import play.api.data.Forms._
import models.TigerHireModel

case class LoginData(username: String, password: String)

@Singleton
//class TigerHire @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  //private val model = new TigerHireModel(db)
class TigerHire @Inject()(cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {
  
  let jobForm = Form(
    mapping(
      "jobTitle" -> nonEmptyText,
      "companyName" -> nonEmptyText,
      "location" -> nonEmptyText,
      "remoteType" -> nonEmptyText,
      "salary" -> nonEmptyText,
      "questions" -> seq(text)
    )(JobPosting.apply)(JobPosting.unapply)
  )

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
            val jobTitle = List("Software Engineer","Data Engineer","Software Engineer")
            val company = List("Mastercard","Visa","Paypal")
            val location = List("Morrisville, NC","Austin, TX","Denver, CO")
            val remoteType = List("Hybrid", "Remote","On-site")
            val employment = List("Full-time","Part-time","Part-time")
            val salary = "$100,000 - $120,000 per year"
            val description = "At Mastercard, Software Engineers work directly with Software Development Engineers in small teams and are deeply engaged throughout the entire development process. They are directly responsible for ensuring great products and analytics for our clients. Innovation is also a key facet in the role. Software Quality Engineers are expected to never settle for the status quo in how Mastercard approaches product quality and always look for ways to accelerate or improve the testing tactics taken."
            val qualifications = List(
            "Currently enrolled in a bachelor’s degree program majoring in Computer Science, Engineering, or related fields with a graduation date of December 2023 – Spring 2024",
            "Less than one year of professional experience",
            "Strong analytic skills and problem-solving mindset; ability to think outside of the box to solve problems",
            "Demonstrated ability to thrive on small, highly collaborative teams and work in an agile environment",
            "Leadership experience or heavy involvement in campus clubs, teams, or organizations",
            "Attention to detail and organizational skill",
            "Interest in learning and working with new technologies"
            )
            Ok(views.html.home(jobPosts,jobTitle,company,location,remoteType,employment))
        }.getOrElse(Redirect(routes.TigerHire.login))
    }

   def searchJobTitle = Action { implicit request =>
     val query = request.getQueryString("search").getOrElse("")
     val company = List("Mastercard","Visa","Paypal")
     val location = List("Morrisville, NC","Austin, TX","Denver, CO")
     val remoteType = List("Hybrid", "Remote", "On-site")
     val jobTitles = List("Software Engineer", "Data Intern","Software Engineer")
     val employment = List("Full-time","Part-time","Part-time")
     val filteredJobTitles = jobTitles.filter(_.toLowerCase.contains(query.toLowerCase))
     val usernameOption = request.session.get("username")
     usernameOption.map { username =>
       val jobPosts = models.TigerHireModel.getJobPost(username)

       Ok(views.html.home(jobPosts, filteredJobTitles,company,location,remoteType,employment))
     }.getOrElse(Redirect(routes.TigerHire.login))
   }

  def profile = Action {
    val name = "Mark Lewis"
    val pronouns = "He/Him"
    val bio = "Simulator of planetary rings, Scala zealot, avid roller skater, and general lover of programming and technology."
    val education = "B.S. Computer Science -- Trinity University \n PhD, Roller Derbying -- RollerCade University"
    val experience = "Professor at Trinity University -- 27 Years Senior Software Engineer -- Amazon Professor at Trinity University -- 4 months"

    Ok(views.html.profile(name, pronouns, bio, education, experience))
  }

  def favorites = TODO

 def job = Action {
    val jobTitle = "Software Engineer"
    val company = "Mastercard"
    val location = "Morrisville, NC"
    val remoteType = "Hybrid"
    val salary = "$100,000 - $120,000 per year"
    val description = "At Mastercard, Software Engineers work directly with Software Development Engineers in small teams and are deeply engaged throughout the entire development process. They are directly responsible for ensuring great products and analytics for our clients. Innovation is also a key facet in the role. Software Quality Engineers are expected to never settle for the status quo in how Mastercard approaches product quality and always look for ways to accelerate or improve the testing tactics taken."
    val qualifications = List(
      "Currently enrolled in a bachelor’s degree program majoring in Computer Science, Engineering, or related fields with a graduation date of December 2023 – Spring 2024",
      "Less than one year of professional experience",
      "Strong analytic skills and problem-solving mindset; ability to think outside of the box to solve problems",
      "Demonstrated ability to thrive on small, highly collaborative teams and work in an agile environment",
      "Leadership experience or heavy involvement in campus clubs, teams, or organizations",
      "Attention to detail and organizational skill",
      "Interest in learning and working with new technologies"
    )
    Ok(views.html.job(jobTitle, company, location, remoteType, salary, description, qualifications))
  }

  /*
  def home = Action {
    Ok(views.html.home())
  }
  */

  def applicationPage = Action {
    val jobTitle = "Software Engineer"
    val company = "Mastercard"
    val location = "Morrisville, NC"
    val remoteType = "Hybrid"

    Ok(views.html.applicationPage(jobTitle, company, location, remoteType))
  }

  def submitApplication = TODO

  def company = Action {
    val name = "Mastercard"
    val purpose = "We work to connect and power an inclusive digital economy that benefits everyone, everywhere by making transactions safe, simple, smart and accessible. Using secure data and networks, partnerships and passion, our innovations and solutions help individuals, financial institutions, governments and businesses realize their greatest potential. Our decency quotient, or DQ, drives our culture and everything we do inside and outside of our company."
    val companyType = "Payment Processing and Technology"
    val dateFounded = "1966"

    Ok(views.html.company(name, purpose, companyType, dateFounded))
  }

  def createJobPage = Action {
    Ok(views.html.createJobPage(jobForm))
  }

  def submitJobPosting = Action.async { implicit request =>
    withSessionUserid { userid =>
      model.addJobPosting(salary, location, remote, hours, cId, id).map(count => Ok(Json.toJson(count > 0)))
    }
  }

  def inbox = Action {
    val username = "mlewis"
    val messages = List(("amazon", "We want you to work at Amazon!"))
    Ok(views.html.inbox(username, messages))
  }

  def sendMessage = TODO


  def validateLogin = TODO
  //= Action.async { implicit request => }


  def createNewUser = Action { 
    Ok(views.html.newUser()) 
  }

  def updateProfile = TODO
}
