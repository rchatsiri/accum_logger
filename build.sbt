name := "accum_logger"

version := "0.0.2"

scalaVersion := "2.11.2"

organization := "dev.infra.accumlogger"

retrieveManaged := true

fork in run := true


val projectMainClass = "ApplicationMain"
mainClass in (Compile, packageBin) := Some(projectMainClass)

libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.2"

// https://mvnrepository.com/artifact/org.slf4j/log4j-over-slf4j
libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.8.0-beta1"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.8.0-beta1" % Test

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.9"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.12" % "test"


libraryDependencies += "junit" % "junit" % "4.8.1" % "test"


dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.5"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.5"
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.5"




resolvers += "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.0.0"

resolvers ++= Seq(
  "Sonatype Snapshots Repository"  at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases Repository"   at "http://oss.sonatype.org/content/repositories/releases",
  "Spray Repository" at "http://repo.spray.io",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/",
  "Akka Releases Repository" at "http://repo.akka.io/releases/",
  "Maven Central" at "https://repo1.maven.org/maven2/",
  "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
)


//Stream : https://doc.akka.io/docs/akka-stream-kafka/current/home.html
libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.3",
    "com.typesafe.akka" %% "akka-testkit" % "2.5.3" % Test,
    "com.typesafe.akka" %% "akka-http" % "10.0.9",
    "com.typesafe.akka" %% "akka-http-testkit" % "10.0.9" % Test,
    "com.typesafe.akka" %% "akka-stream" % "2.5.3",
    "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.3" % Test,
    "com.typesafe.akka" %% "akka-cluster" % "2.5.3",
    "com.typesafe.akka" %% "akka-cluster-sharding" %  "2.5.3",
    "com.typesafe.akka" %% "akka-distributed-data" % "2.5.3",
    "com.typesafe.akka" %% "akka-persistence" % "2.5.3",
    "com.typesafe.akka" %% "akka-slf4j" % "2.5.3",
    "com.paypal"        %% "cascade-json"     % "0.5.0",
    "com.typesafe.akka" %% "akka-stream-kafka" % "1.0-RC1",
    "org.apache.spark" % "spark-core_2.11" % "2.4.1",
    "org.apache.spark" % "spark-sql_2.11" % "2.4.1",
    "org.apache.spark" %% "spark-streaming" % "2.4.1",
    "org.apache.spark" %% "spark-streaming-flume" % "2.4.1",
    "org.apache.spark" %% "spark-streaming-flume-assembly" % "2.4.1",
    "org.apache.spark" %% "spark-streaming-flume-sink" % "2.4.1",
    "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.4.1",
    "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.0",
    "org.apache.kafka" % "kafka-clients" % "2.2.1"
  )
}

// Scala 2.10, 2.11, Query with MySQL
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "com.typesafe.slick" %% "slick-testkit" % "3.1.1" % "test",
  "com.github.tototoshi" %% "slick-joda-mapper" % "2.1.0",
  "com.typesafe.slick" %% "slick-codegen" % "3.1.1",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.1.1",
  "mysql" % "mysql-connector-java" % "5.1.38",
  "joda-time" % "joda-time" % "2.7",
  "org.joda" % "joda-convert" % "1.7",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.3"

)



//Dependency injection
libraryDependencies ++= Seq("org.scaldi" %% "scaldi-akka" % "0.5.8")

//encrypt
libraryDependencies ++= Seq("org.mindrot" % "jbcrypt" % "0.3m")

//Apache Common io
libraryDependencies ++= Seq("commons-io" % "commons-io" % "2.6")

//Ref: https://stackoverflow.com/questions/41303037/why-does-spark-application-fail-with-classnotfoundexception-failed-to-find-dat
//  case x => MergeStrategy.first
//assemblyMergeStrategy in assembly := {
//   {
//   case PathList("META-INF", xs @ _*) => MergeStrategy.discard
//    case "reference.conf" => MergeStrategy.concat
//    case x => MergeStrategy.first
//   }//}


scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-language:_",
  "-encoding", "UTF-8"
)

javaOptions := Seq("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000", "-target", "1.8")
