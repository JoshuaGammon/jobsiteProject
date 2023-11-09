package models

import collection.mutable

object TigerHireModel {
    private val users = mutable.Map[String, String]("mlewis" -> "1234") //temporary data while DB in progress

    def validateUser(username: String, password: String): Boolean = {
        users.get(username).map(_ == password).getOrElse(false)
    }

    def createUser(email: String username: String, password1: String, password2: String): Boolean = ???
}