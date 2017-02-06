name := "cafex-menu"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.assertj" % "assertj-core" % "3.5.2" % Test,
  "junit" % "junit" % "4.12" % Test,
  "org.specs2" %% "specs2-core" % "3.8.6" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
