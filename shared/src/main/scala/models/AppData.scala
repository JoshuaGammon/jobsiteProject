package models

//import play.api.libs.json.Json

//case class UserData(username: String, password: String)
case class JobItem(salary: Option[String], location: Option[String], remote: Option[String], hours: Option[String], cId: Option[Int], id: Int, name: String, description: Option[String])

case class ProfileItem(description: String, education: String, name: String, university: String, email: String, pronouns: String, aId: Option[Int])

case class RProfileItem(description: Option[String], location: Option[String], name: Option[String], currentPos: Option[String], email: Option[String], pronouns: Option[String], rId: Option[Int])