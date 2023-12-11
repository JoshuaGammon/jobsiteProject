package models

//(salary: String, location: String, remote: String, hours: String, cId: Int, id: Int, name: String)

import collection.mutable
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import models.Tables._
import scala.concurrent.Future

/*

object TigerHireModel {
    private val users = mutable.Map[String, String]("mlewis" -> "1234") //temporary data while DB in progress
    private val jobPosts = mutable.Map[String, List[String]]("mlewis" -> List("Job Post 1","Job Post 2"))
    // private val inboxMessages = mutable.Map[String, List[String]]

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

    def getJobs(): Future[Seq[JobItem]] = {
        db.run(
            (for {
                job <- Jobs
            } yield {
                job
            }).result
        ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
    }

    def getJob(id: Int): Future[Seq[JobItem]] = {
        db.run(
            (for {
                job <- Jobs if job.id === id
            } yield {
                job
            }).result
        ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
    }

//   def getInboxJobs(username: String): Future[Seq[JobItem]] = {
//     db.run(
//       (for {
//         applicant <- Applicants if applicant.username === username
//         in <- Inbox if in.aId === applicant.id
//         job <- Jobs if job.id === in.jId
//       } yield {
//         job
//       }).result
//     ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
//   }

  def getRInboxJobs(username: String): Future[Seq[JobItem]] = {
    db.run(
      (for {
        recruiter <- Recruiters if recruiter.username === username
        comp <- Company if comp.id === recruiter.cId
        job <- Jobs if job.cId === comp.id
      } yield {
        job
      }).result
    ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
  }

//   def getRProfileJobs(username: String): Future[Seq[JobItem]] = {
//     db.run(
//       (for {
//         applicant <- Applicants if applicant.username === username
//         in <- Inbox if in.aId === applicant.id
//         job <- Jobs if job.id === in.jId
//       } yield {
//         job
//       }).result
//     ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
//   }



def getRProfile(username: String): Future[Seq[RProfileItem]] = {
    db.run(
      (for {
        recruiter <- Recruiters if recruiter.username === username
        profile <- RProfile if profile.rId === recruiter.id
      } yield {
        profile
      }).result
    ).map (profile => profile.map(profile => RProfileItem(profile.description, profile.location, profile.name, profile.currentPosition, profile.email, profile.pronouns, profile.rId)))
  }

  def getProfile(username: String): Future[Seq[ProfileItem]] = {
    db.run(
      (for {
        applicant <- Applicants if applicant.username === username
        profiles <- AProfile if profiles.aId === applicant.id
      } yield {
        profiles
      }).result
    ).map(profiles => profiles.map(profiles => ProfileItem(profiles.description, profiles.education, profiles.name, profiles.university, profiles.email, profiles.pronouns, profiles.aId)))
  }
    
  def searchJobTitle(query: String): Future[Seq[JobItem]] = {
        db.run(
            Jobs.filter(_.name.toLowerCase.like(s"%${query.toLowerCase}%")).result
        ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
        
 
    }    
//    def getJobsByCompanyId(cId: Long): Future[Seq[JobItem]] = {
//         db.run(
//         Jobs.filter(_.cId === cId).result
//         ).map(jobs => jobs.map(job =>
//         JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name)
//         ))
// }
    def getJobsBycId(cId: Int): Future[Seq[JobItem]] = {
    db.run(
        Jobs.filter(_.cId === cId).result
    ).map(jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
}


}



/*
    def createUser(username: String, password: String): Boolean = {
        if (users.contains(username)) false else {
        users(username) = password
        true
      }
    }


    

    

    def addJobPosting(salary: String, location: String, remote: String, hours: String, cId: Int, id: Int): Future[Int] = {
        db.run(Jobs += JobsRow(salary, location, remote, hours, cId, -1))
    }

}   */

    // def getPrivateMessage(username: String): Seq[String] = {
    //     inboxMessages.get(username).getOrElse(Nil)
    // }

    // def addPrivateMessage(username: String, message: String): Unit = {
    //     inboxMessages(username) = message :: inboxMessages.get(username).getOrElse(Nil)
    // }

