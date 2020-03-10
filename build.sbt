  enablePlugins(GatlingPlugin)

name := "image-service-load-test"
version := "0.1"

scalaVersion := "2.12.8"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")


libraryDependencies ++= Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.1.2" % "test,it",
    "io.gatling"            % "gatling-test-framework"    % "3.1.2" % "test,it"
  )

