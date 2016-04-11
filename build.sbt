name := """play-slick-silhouette-postgres"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

resolvers := ("Atlassian Releases" at "https://maven.atlassian.com/public/") +: resolvers.value

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  cache,
  ws,
  evolutions,
  filters,
  "org.webjars" %% "webjars-play" % "2.5.0",
  "com.h2database" % "h2" % "1.4.188",
  "org.postgresql" % "postgresql" % "9.4.1208",
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.0",
  "com.mohiva" %% "play-silhouette" % "4.0.0-BETA4",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "4.0.0-BETA4",
  "com.mohiva" %% "play-silhouette-persistence-memory" % "4.0.0-BETA4",
  "com.mohiva" %% "play-silhouette-testkit" % "4.0.0-BETA4" % "test",
  "net.codingwell" %% "scala-guice" % "4.0.1",
  "com.iheart" %% "ficus" % "1.2.0",
  "com.adrianhurt" %% "play-bootstrap" % "1.1-P25-B3-SNAPSHOT",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test
)