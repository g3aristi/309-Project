
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
object signin extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[Application.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""

<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
    <link href='"""),_display_(Seq[Any](/*17.18*/routes/*17.24*/.Assets.at("bootstrap/css/bootstrap.min.css"))),format.raw/*17.69*/("""' rel="stylesheet">

  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top"></nav>
    <div style="margin-top:15%"></div>
    <div class="container" style="width:500px;">

    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(routes.Application.authenticate,'class -> "form-signin")/*26.74*/ {_display_(Seq[Any](format.raw/*26.76*/("""
      
        """),_display_(Seq[Any](/*28.10*/if(form.hasGlobalErrors)/*28.34*/ {_display_(Seq[Any](format.raw/*28.36*/("""
        <p class="error">"""),_display_(Seq[Any](/*29.27*/form/*29.31*/.globalError.message)),format.raw/*29.51*/("""</p>
          """)))})),format.raw/*30.12*/("""
        
        <h2 class="form-signin-heading">Please sign in</h2>

        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required="" autofocus="" value""""),_display_(Seq[Any](/*35.139*/form("email")/*35.152*/.value)),format.raw/*35.158*/(""""><br />

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password"  placeholder="Password" required="" placeholder="Password">

        

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    
    """)))})),format.raw/*44.6*/("""

   

  </body>
</html>"""))}
    }
    
    def render(form:Form[Application.Login]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[Application.Login]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 12 18:48:18 EDT 2015
                    SOURCE: /Users/narimanmammadli/Desktop/CommunityFunding/app/views/signin.scala.html
                    HASH: 5fdd3523ee7e7365676eb5c2b4fd22c13b7f013d
                    MATRIX: 792->1|917->32|1342->421|1357->427|1424->472|1657->670|1672->676|1743->738|1783->740|1836->757|1869->781|1909->783|1972->810|1985->814|2027->834|2075->850|2391->1129|2414->1142|2443->1148|2808->1482
                    LINES: 26->1|29->1|45->17|45->17|45->17|54->26|54->26|54->26|54->26|56->28|56->28|56->28|57->29|57->29|57->29|58->30|63->35|63->35|63->35|72->44
                    -- GENERATED --
                */
            