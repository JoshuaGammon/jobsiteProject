package models

import collection.mutable
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import models.Tables._
import scala.concurrent.Future
/*
object TigerHireModel {
    private val users = mutable.Map[String, String]("mlewis" -> "1234") //temporary data while DB in progress
    private val jobPosts = mutable.Map[String, List[String]]("mlewis" -> List("Job Post 1","Job Post 2"))

    def validateUser(username: String, password: String): Boolean = {
        users.get(username).map(_ == password).getOrElse(false)
    }
*/

class TigerHireModel(db: Database)(implicit ec: ExecutionContext) {
    def validateApplicant(username: String, password: String): Future[Boolean] = {
        val matches = db.run(Applicants.filter(ApplicantsRow => ApplicantsRow.username === username && ApplicantsRow.password === password).result)
        matches.map(ApplicantsRows => ApplicantsRows.nonEmpty)
    }

    def validateRecruiters(username: String, password: String): Future[Boolean] = {
        val matches = db.run(Recruiters.filter(RecruitersRow => RecruitersRow.username === username && RecruitersRow.password === password).result)
        matches.map(RecruitersRows => RecruitersRows.nonEmpty)
    }

    def createUser(username: String, password: String): Future[Boolean] = {
        db.run(Applicants += ApplicantsRow(-1, username, password)).map(addCount => addCount > 0)
    }

    // def getCompanyJobs(name: String): Future[Seq[String]] = { //just gets list of all job titles (dk how db looks yet)
    //     db.run(
    //         (for {
    //             company <- Company if company.name === name
    //             job <- Jobs if job.cId === company.id
    //         } yield {
    //             job.salary
    //         }).result
    //     )
    // }
}
/*
    def createUser(username: String, password: String): Boolean = {
        if (users.contains(username)) false else {
        users(username) = password
        true
      }
    }

    def getJobPost(username: String): Seq[String] = {
        jobPosts.get(username).getOrElse(Nil)
    }

}   */
