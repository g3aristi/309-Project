
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object register extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Community Fund Signin</title>

    <!-- Bootstrap core CSS -->
    <link href='"""),_display_(Seq[Any](/*13.18*/routes/*13.24*/.Assets.at("bootstrap/css/bootstrap.min.css"))),format.raw/*13.69*/("""' rel="stylesheet">
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top"></nav>
    <div style="margin-top:15%"></div>
    <div class="container" style="width:500px;">

      """),_display_(Seq[Any](/*21.8*/helper/*21.14*/.form(routes.Application.createUser,'class->"form-register")/*21.74*/{_display_(Seq[Any](format.raw/*21.75*/("""
      
     
        <h2 class="form-register-heading">Please resgister</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required="" autofocus=""><br />
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
     
    """)))})),format.raw/*32.6*/("""
    
    </div>
  </body>

</html>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 12 18:51:14 EDT 2015
                    SOURCE: /Users/narimanmammadli/Desktop/CommunityFunding/app/views/register.scala.html
                    HASH: b142006eefdfe76d6b30eea3eef7002e6be4f83b
                    MATRIX: 858->0|1294->400|1309->406|1376->451|1610->650|1625->656|1694->716|1733->717|2350->1303
                    LINES: 29->1|41->13|41->13|41->13|49->21|49->21|49->21|49->21|60->32
                    -- GENERATED --
                */
            