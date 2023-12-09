package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class TigerHire @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  //private val model = new TigerHireModel(db)

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

  def createJobPage = TODO

  def submitJobPosting = TODO

  def inbox = Action {
    val username = "mlewis"
    val messages = List(("amazon", "We want you to work at Amazon!"))
    Ok(views.html.inbox(username, messages))
  }

  def sendMessage = TODO

  def validateLogin = TODO
  //= Action.async { implicit request => }

  def createNewUser = TODO

  def updateProfile = TODO
}
