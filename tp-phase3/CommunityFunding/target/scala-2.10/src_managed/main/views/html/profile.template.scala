
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
object profile extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Profile</title>

    <!-- Bootstrap Core CSS -->
    <link href='"""),_display_(Seq[Any](/*15.18*/routes/*15.24*/.Assets.at("bootstrap/css/bootstrap.min.css"))),format.raw/*15.69*/("""' rel="stylesheet">
</head>

<body id="page-top" class="index">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                           <a href= "">Home</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">My Profile</a>
                    </li>
                    <li class="page-scroll">
                        <a href=" ">Logout</a>
                    </li>
                </ul>
            </div>
    </nav><br><br><br>

    <!-- Header -->
    <header>
        <br><br>
        <div class="container">
            <div class="col-lg-5">
                <div class="intro-text">
                    <h1>My Profile</h1>
                </div>
                <br>
                <img class="img-responsive" src='"""),_display_(Seq[Any](/*48.51*/routes/*48.57*/.Assets.at("bootstrap/img/profile.png"))),format.raw/*48.96*/("""'>
                <p>UserName</p>
                <a href="" class="btn btn-primary">Edit</a><br>
            </div>
            <div class="col-lg-6">
                <h1>My Reputation<h1>
                <svg width="500" height="300">
                    <!-- first:middle, bottom-left, top-right, top-left, bottom-right -->
                    <polygon points="100,10 40,198 190,78 10,78 160,198"
                    style="fill:yellow;stroke:yellow;stroke-width:2;" />
                    Sorry, your browser does not support inline SVG.
                </svg>
            </div>
        </div>
    </header>

    <!-- Profile activities -->
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <p><a class="btn btn-primary" href="" role="button">My Friends</a></p>
                <ol>
                    <li>Friend</li>
                    <li>Friend2</li>
                    <li>Friend3</li>
                </ol>
            </div>
            <div class="col-lg-3">
                <p><a class="btn btn-primary" href="" role="button">My Communitites</a></p>
                <ol>
                    <li>CommunityName</li>
                    <li>CommunityName2</li>
                    <li>CommunityName3</li>
                </ol>
            </div>
            <div class="col-lg-3">
              <p><a class="btn btn-primary" href="" role="button">My Projects</a></p>
              <ol>
                <li>Project</li>
                <li>Project2</li>
                <li>Project3</li>
              </ol>
            </div>
            <div class="col-lg-3">
                <p><a class="btn btn-primary" href="" role="button">Projects Funded</a></p>
                <ol>
                    <li>Project</li>
                    <li>Project2</li>
                    <li>Project3</li>
                </ol>
            </div>
        </div>
    </div>

    <!-- footer -->
    <div class="col-lg-10 col-lg-offset-1">
        <hr class="small">
        <div class="row">
            <div class="col-md-4 col-sm-4">
                <a class="btn btn-primary" href="" role="button" style="font-size: 30px">Create Community</a>
            </div>

            <div class="col-md-4 col-sm-4">
                <a class="btn btn-primary" href="" role="button" style="font-size: 30px">Create Project</a>
            </div>

            <div class="col-md-4 col-sm-7">
                <a class="btn btn-primary" href="" role="button" style="font-size: 30px">Explore communities</a>
                <br><br><br>
            </div>
        </div>
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
                    DATE: Thu Mar 12 18:57:51 EDT 2015
                    SOURCE: /Users/narimanmammadli/Desktop/CommunityFunding/app/views/profile.scala.html
                    HASH: 6b5439af6eaeb8dba86c21b91dbdc2d7f75d8bfb
                    MATRIX: 857->0|1248->355|1263->361|1330->406|2485->1525|2500->1531|2561->1570
                    LINES: 29->1|43->15|43->15|43->15|76->48|76->48|76->48
                    -- GENERATED --
                */
            