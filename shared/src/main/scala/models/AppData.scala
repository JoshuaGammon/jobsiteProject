package models

//import play.api.libs.json.Json

//case class UserData(username: String, password: String)
case class JobItem(salary: Option[String], location: Option[String], remote: Option[String], hours: Option[String], cId: Option[Int], id: Int, name: String)

case class ProfileItem(description: Option[String], education: Option[String], name: Option[String], university: Option[String], email: Option[String], pronouns: Option[String], aId: Option[Int])