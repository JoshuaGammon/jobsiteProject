// @GENERATOR:play-routes-compiler
// @SOURCE:server/conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  TigerHire_0: controllers.TigerHire,
  // @LINE:29
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    TigerHire_0: controllers.TigerHire,
    // @LINE:29
    Assets_1: controllers.Assets
  ) = this(errorHandler, TigerHire_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TigerHire_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.TigerHire.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.TigerHire.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """newUser""", """controllers.TigerHire.newUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validateLogin""", """controllers.TigerHire.validateLogin"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createNewUser""", """controllers.TigerHire.createNewUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.TigerHire.profile"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateProfile""", """controllers.TigerHire.updateProfile"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favorites""", """controllers.TigerHire.favorites"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """job""", """controllers.TigerHire.job"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apply""", """controllers.TigerHire.applicationPage"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitApplication""", """controllers.TigerHire.submitApplication"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """company""", """controllers.TigerHire.company"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createJob""", """controllers.TigerHire.createJobPage"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitJobPosting""", """controllers.TigerHire.submitJobPosting"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """inbox""", """controllers.TigerHire.inbox"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessage""", """controllers.TigerHire.sendMessage"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """versionedAssets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_TigerHire_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_TigerHire_index0_invoker = createInvoker(
    TigerHire_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_TigerHire_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_TigerHire_login1_invoker = createInvoker(
    TigerHire_0.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_TigerHire_newUser2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newUser")))
  )
  private[this] lazy val controllers_TigerHire_newUser2_invoker = createInvoker(
    TigerHire_0.newUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "newUser",
      Nil,
      "GET",
      this.prefix + """newUser""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_TigerHire_validateLogin3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validateLogin")))
  )
  private[this] lazy val controllers_TigerHire_validateLogin3_invoker = createInvoker(
    TigerHire_0.validateLogin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "validateLogin",
      Nil,
      "POST",
      this.prefix + """validateLogin""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_TigerHire_createNewUser4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createNewUser")))
  )
  private[this] lazy val controllers_TigerHire_createNewUser4_invoker = createInvoker(
    TigerHire_0.createNewUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "createNewUser",
      Nil,
      "POST",
      this.prefix + """createNewUser""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_TigerHire_profile5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_TigerHire_profile5_invoker = createInvoker(
    TigerHire_0.profile,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "profile",
      Nil,
      "GET",
      this.prefix + """profile""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_TigerHire_updateProfile6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateProfile")))
  )
  private[this] lazy val controllers_TigerHire_updateProfile6_invoker = createInvoker(
    TigerHire_0.updateProfile,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "updateProfile",
      Nil,
      "POST",
      this.prefix + """updateProfile""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_TigerHire_favorites7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favorites")))
  )
  private[this] lazy val controllers_TigerHire_favorites7_invoker = createInvoker(
    TigerHire_0.favorites,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "favorites",
      Nil,
      "GET",
      this.prefix + """favorites""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_TigerHire_job8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("job")))
  )
  private[this] lazy val controllers_TigerHire_job8_invoker = createInvoker(
    TigerHire_0.job,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "job",
      Nil,
      "GET",
      this.prefix + """job""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_TigerHire_applicationPage9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apply")))
  )
  private[this] lazy val controllers_TigerHire_applicationPage9_invoker = createInvoker(
    TigerHire_0.applicationPage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "applicationPage",
      Nil,
      "GET",
      this.prefix + """apply""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_TigerHire_submitApplication10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitApplication")))
  )
  private[this] lazy val controllers_TigerHire_submitApplication10_invoker = createInvoker(
    TigerHire_0.submitApplication,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "submitApplication",
      Nil,
      "POST",
      this.prefix + """submitApplication""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_TigerHire_company11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("company")))
  )
  private[this] lazy val controllers_TigerHire_company11_invoker = createInvoker(
    TigerHire_0.company,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "company",
      Nil,
      "GET",
      this.prefix + """company""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_TigerHire_createJobPage12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createJob")))
  )
  private[this] lazy val controllers_TigerHire_createJobPage12_invoker = createInvoker(
    TigerHire_0.createJobPage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "createJobPage",
      Nil,
      "GET",
      this.prefix + """createJob""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_TigerHire_submitJobPosting13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitJobPosting")))
  )
  private[this] lazy val controllers_TigerHire_submitJobPosting13_invoker = createInvoker(
    TigerHire_0.submitJobPosting,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "submitJobPosting",
      Nil,
      "POST",
      this.prefix + """submitJobPosting""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_TigerHire_inbox14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("inbox")))
  )
  private[this] lazy val controllers_TigerHire_inbox14_invoker = createInvoker(
    TigerHire_0.inbox,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "inbox",
      Nil,
      "GET",
      this.prefix + """inbox""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_TigerHire_sendMessage15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessage")))
  )
  private[this] lazy val controllers_TigerHire_sendMessage15_invoker = createInvoker(
    TigerHire_0.sendMessage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TigerHire",
      "sendMessage",
      Nil,
      "POST",
      this.prefix + """sendMessage""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Assets_at16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at16_invoker = createInvoker(
    Assets_1.at(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Prefix must match `play.assets.urlPrefix`""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Assets_versioned17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("versionedAssets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned17_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """versionedAssets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_TigerHire_index0_route(params@_) =>
      call { 
        controllers_TigerHire_index0_invoker.call(TigerHire_0.index)
      }
  
    // @LINE:7
    case controllers_TigerHire_login1_route(params@_) =>
      call { 
        controllers_TigerHire_login1_invoker.call(TigerHire_0.login)
      }
  
    // @LINE:8
    case controllers_TigerHire_newUser2_route(params@_) =>
      call { 
        controllers_TigerHire_newUser2_invoker.call(TigerHire_0.newUser)
      }
  
    // @LINE:9
    case controllers_TigerHire_validateLogin3_route(params@_) =>
      call { 
        controllers_TigerHire_validateLogin3_invoker.call(TigerHire_0.validateLogin)
      }
  
    // @LINE:10
    case controllers_TigerHire_createNewUser4_route(params@_) =>
      call { 
        controllers_TigerHire_createNewUser4_invoker.call(TigerHire_0.createNewUser)
      }
  
    // @LINE:12
    case controllers_TigerHire_profile5_route(params@_) =>
      call { 
        controllers_TigerHire_profile5_invoker.call(TigerHire_0.profile)
      }
  
    // @LINE:13
    case controllers_TigerHire_updateProfile6_route(params@_) =>
      call { 
        controllers_TigerHire_updateProfile6_invoker.call(TigerHire_0.updateProfile)
      }
  
    // @LINE:14
    case controllers_TigerHire_favorites7_route(params@_) =>
      call { 
        controllers_TigerHire_favorites7_invoker.call(TigerHire_0.favorites)
      }
  
    // @LINE:16
    case controllers_TigerHire_job8_route(params@_) =>
      call { 
        controllers_TigerHire_job8_invoker.call(TigerHire_0.job)
      }
  
    // @LINE:17
    case controllers_TigerHire_applicationPage9_route(params@_) =>
      call { 
        controllers_TigerHire_applicationPage9_invoker.call(TigerHire_0.applicationPage)
      }
  
    // @LINE:18
    case controllers_TigerHire_submitApplication10_route(params@_) =>
      call { 
        controllers_TigerHire_submitApplication10_invoker.call(TigerHire_0.submitApplication)
      }
  
    // @LINE:20
    case controllers_TigerHire_company11_route(params@_) =>
      call { 
        controllers_TigerHire_company11_invoker.call(TigerHire_0.company)
      }
  
    // @LINE:22
    case controllers_TigerHire_createJobPage12_route(params@_) =>
      call { 
        controllers_TigerHire_createJobPage12_invoker.call(TigerHire_0.createJobPage)
      }
  
    // @LINE:23
    case controllers_TigerHire_submitJobPosting13_route(params@_) =>
      call { 
        controllers_TigerHire_submitJobPosting13_invoker.call(TigerHire_0.submitJobPosting)
      }
  
    // @LINE:25
    case controllers_TigerHire_inbox14_route(params@_) =>
      call { 
        controllers_TigerHire_inbox14_invoker.call(TigerHire_0.inbox)
      }
  
    // @LINE:26
    case controllers_TigerHire_sendMessage15_route(params@_) =>
      call { 
        controllers_TigerHire_sendMessage15_invoker.call(TigerHire_0.sendMessage)
      }
  
    // @LINE:29
    case controllers_Assets_at16_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_at16_invoker.call(Assets_1.at(file))
      }
  
    // @LINE:30
    case controllers_Assets_versioned17_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned17_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
