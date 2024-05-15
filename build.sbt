name := "WebTrafficAnalysis"
version := "0.1"
scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.3.1",
  "org.apache.spark" %% "spark-sql" % "3.3.1",
  "com.lihaoyi" %% "os-lib" % "0.7.8",
  "org.knowm.xchart" % "xchart" % "3.8.1",
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)
