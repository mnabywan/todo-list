name := "TodoList"
 
version := "1.0" 
      
lazy val `todolist` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )
libraryDependencies += "com.h2database" % "h2" % "1.4.192"
libraryDependencies += evolutions
libraryDependencies ++= Seq(jdbc, "org.playframework.anorm" %% "anorm" % "2.6.2")
libraryDependencies ++= Seq(
  "com.typesafe.slick" % "slick_2.10" % "2.1.0",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "com.typesafe.play" % "play-jdbc_2.10" % "2.4.0-RC1",
  cache,
  anorm
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

      