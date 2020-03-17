name := "accum_logger"

version := "0.0.2"

scalaVersion := "2.11.2"

organization := "dev.infra.accumlogger"

retrieveManaged := true

fork in run := true
 
enablePlugins(PackPlugin)

packMain := Map("ApplicationMain" -> "dev.infra.accumlogger.ApplicationMain")
  
val projectMainClass = "ApplicationMain"
mainClass in (Compile, packageBin) := Some(projectMainClass)
  
resolvers ++= Seq(
  "Sonatype Snapshots Repository"  at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases Repository"   at "https://oss.sonatype.org/content/repositories/releases", 
  "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/",
  "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/",
  "Akka Releases Repository" at "https://repo.akka.io/releases/",
  "Maven Central" at "https://repo1.maven.org/maven2/",
  "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
)

libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.8"

libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.2"
 
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.9"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.12" % "test" 

libraryDependencies += "junit" % "junit" % "4.8.1" % "test"
 
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.0.0" 

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.5"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.5"

libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.5"
     
libraryDependencies ++= Seq("org.mindrot" % "jbcrypt" % "0.3m")
 
libraryDependencies ++= Seq("commons-io" % "commons-io" % "2.6")

libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided"

libraryDependencies += "com.softwaremill.macwire" %% "macrosakka" % "2.3.3" % "provided"

libraryDependencies += "com.softwaremill.macwire" %% "util" % "2.3.3"

libraryDependencies += "com.softwaremill.macwire" %% "proxy" % "2.3.3"
 

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
    "org.apache.kafka" % "kafka-clients" % "2.2.1"
  )
}


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


assemblyMergeStrategy in assembly := { 
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard 
    case "reference.conf" => MergeStrategy.concat
    case x => MergeStrategy.first
   }
}
 
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-language:_",
  "-target:jvm-1.7",
  "-encoding", "UTF-8"
)
 
javaOptions := Seq("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000") 