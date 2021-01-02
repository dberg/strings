import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.cybergstudio",
      scalaVersion := "2.13.4",
      version      := "0.1.0"
    )),
    name := "strings",
    libraryDependencies += scalaTest % Test
  )
