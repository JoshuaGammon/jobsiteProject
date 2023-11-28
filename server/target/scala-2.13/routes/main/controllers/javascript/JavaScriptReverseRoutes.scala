// @GENERATOR:play-routes-compiler
// @SOURCE:server/conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseTigerHire(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def sendMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.sendMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessage"})
        }
      """
    )
  
    // @LINE:10
    def createNewUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.createNewUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createNewUser"})
        }
      """
    )
  
    // @LINE:20
    def company: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.company",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "company"})
        }
      """
    )
  
    // @LINE:12
    def profile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.profile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
        }
      """
    )
  
    // @LINE:9
    def validateLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.validateLogin",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateLogin"})
        }
      """
    )
  
    // @LINE:22
    def createJobPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.createJobPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createJob"})
        }
      """
    )
  
    // @LINE:25
    def inbox: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.inbox",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inbox"})
        }
      """
    )
  
    // @LINE:18
    def submitApplication: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.submitApplication",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitApplication"})
        }
      """
    )
  
    // @LINE:17
    def applicationPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.applicationPage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "apply"})
        }
      """
    )
  
    // @LINE:14
    def favorites: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.favorites",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "favorites"})
        }
      """
    )
  
    // @LINE:23
    def submitJobPosting: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.submitJobPosting",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitJobPosting"})
        }
      """
    )
  
    // @LINE:13
    def updateProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.updateProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateProfile"})
        }
      """
    )
  
    // @LINE:8
    def newUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.newUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newUser"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:16
    def job: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.job",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "job"})
        }
      """
    )
  
    // @LINE:7
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TigerHire.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:30
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "versionedAssets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
