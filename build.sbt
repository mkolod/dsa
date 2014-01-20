name := "DS-Algo"

version := "1.0"

organization := "us.marek"

scalaVersion := "2.10.3"

scalaSource in Compile <<= baseDirectory(_ / "src/main/scala")

scalaSource in Test <<= baseDirectory(_ / "src/test/scala")

EclipseKeys.withSource := true

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.2" % "test"