package models

import collection.mutable
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import models.Tables._
import scala.concurrent.Future

object TigerHireModel {
    private val users = mutable.Map[String, String]("mlewis" -> "1234") //temporary data while DB in progress
    private val jobPosts = mutable.Map[String, List[String]]("mlewis" -> List("Job Post 1","Job Post 2"))

    def validateUser(username: String, password: String): Boolean = {
        users.get(username).map(_ == password).getOrElse(false)
    }

    def createUser(username: String, password: String): Boolean = {
        if (users.contains(username)) false else {
        users(username) = password
        true
      }
    }

    def getJobPost(username: String): Seq[String] = {
        jobPosts.get(username).getOrElse(Nil)
    }
}
/*

class TigerHireModel(db: Database)(implicit ec: ExecutionContext) {
    def validateUser(username: String, password: String): Future[Boolean] = {
        val matches = db.run(Users.filter(userRow => userRow.username === username && userRow.password === password).result)
        matches.map(userRows => userRows.nonEmpty)
    }

    def createUser(username: String, password: String): Future[Boolean] = {
        db.run(Users += UsersRow(-1, username, password)).map(addCount => addCount > 0)
    }

    def getJobs(): Future[Seq[String]] = { //just gets list of all job titles (dk how db looks yet)
        db.run(
            (for {
                job <- Jobs
            } yield {
                job.title
            }).result
        )
    }
}

    

    

    def addJobPosting(salary: String, location: String, remote: String, hours: String, cId: Int, id: Int): Future[Int] = {
        db.run(Jobs += JobsRow(salary, location, remote, hours, cId, -1))
    }

}
*/
