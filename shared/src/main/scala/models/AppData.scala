package models

//import play.api.libs.json.Json

//case class UserData(username: String, password: String)
case class JobItem(salary: Option[String], location: Option[String], remote: Option[String], hours: Option[String], cId: Option[Int], id: Int, name: String)