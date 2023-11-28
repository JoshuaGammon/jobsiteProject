// @GENERATOR:play-routes-compiler
// @SOURCE:server/conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseTigerHire(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def sendMessage: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessage")
    }
  
    // @LINE:10
    def createNewUser: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createNewUser")
    }
  
    // @LINE:20
    def company: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "company")
    }
  
    // @LINE:12
    def profile: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile")
    }
  
    // @LINE:9
    def validateLogin: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validateLogin")
    }
  
    // @LINE:22
    def createJobPage: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "createJob")
    }
  
    // @LINE:25
    def inbox: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "inbox")
    }
  
    // @LINE:18
    def submitApplication: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitApplication")
    }
  
    // @LINE:17
    def applicationPage: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "apply")
    }
  
    // @LINE:14
    def favorites: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "favorites")
    }
  
    // @LINE:23
    def submitJobPosting: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitJobPosting")
    }
  
    // @LINE:13
    def updateProfile: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateProfile")
    }
  
    // @LINE:8
    def newUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "newUser")
    }
  
    // @LINE:6
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:16
    def job: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "job")
    }
  
    // @LINE:7
    def login: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:29
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def at(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:30
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "versionedAssets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
