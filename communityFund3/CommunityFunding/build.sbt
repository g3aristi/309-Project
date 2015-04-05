name := "CommunityFunding"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

libraryDependencies += "org.webjars" % "bootstrap" % "3.0.2"

play.Project.playJavaSettings
