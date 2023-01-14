ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "scala-precision",
    idePackagePrefix := Some("edu.ant")
  )

lazy val training = (project in file("training"))
  .settings(
    name := "training",
    idePackagePrefix := Some("edu.ant")
  )

lazy val projects = (project in file("projects"))
  .settings(
    name := "projects",
    idePackagePrefix := Some("edu.ant")
  )
