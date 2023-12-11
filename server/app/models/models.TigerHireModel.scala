package models

import collection.mutable
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import models.Tables._
import scala.concurrent.Future

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

    def createApplication(aId: Option[Int], jId: Option[Int], answer1: Option[String], answer2: Option[String], answer3: Option[String], experience: Option[String]): Future[Boolean] = {
        db.run(Appl += ApplRow(aId, jId, -1, answer1, answer2, answer3, experience)).map(addCount => addCount > 0)
    }

    def getJobs(): Future[Seq[JobItem]] = {
        db.run(
            (for {
                job <- Jobs
            } yield {
                job
            }).result
        ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description, job.q1, job.q2, job.q3)))
    }

    def getJob(id: Int): Future[Seq[JobItem]] = {
        db.run(
            (for {
                job <- Jobs if job.id === id
            } yield {
                job
            }).result
        ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description, job.q1, job.q2, job.q3)))
    }

    def getCompanyInfo(id: Int): Future[Seq[CompanyDescription]] = {
    db.run(
        (for {
            company <- Company if company.id === id
        } yield {
            company
        }).result
      ).map (companies => companies.map(company => CompanyDescription(company.headquarters.getOrElse(""), company.name.getOrElse(""), company.purpose.getOrElse(""), company.companyType.getOrElse(""),company.id)))
    }


  def getInboxJobs(username: String): Future[Seq[JobItem]] = {
    db.run(
      (for {
        applicant <- Applicants if applicant.username === username
        in <- Inbox if in.aId === applicant.id
        job <- Jobs if job.id === in.jId
      } yield {
        job
      }).result
    ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description)))
  }

  def getRInboxJobs(username: String): Future[Seq[JobItem]] = {
    db.run(
      (for {
        recruiter <- Recruiters if recruiter.username === username
        comp <- Company if comp.id === recruiter.cId
        job <- Jobs if job.cId === comp.id
      } yield {
        job
      }).result
    ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description, job.q1, job.q2, job.q3)))
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
        ).map (jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description, job.q1, job.q2, job.q3)))
        
 
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
    ).map(jobs => jobs.map(job => JobItem(job.salary, job.location, job.remote, job.hours, job.cId, job.id, job.name, job.description, job.q1, job.q2, job.q3)))
}


}



/*
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

