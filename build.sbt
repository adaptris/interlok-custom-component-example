name := "interlok-service-example"

organization := "com.adaptris"

version := "1.0-SNAPSHOT"

description := "An example project containing custom services"

// Enables publishing to maven repo
publishMavenStyle := true

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

resolvers += "adaptris-public" at "https://nexus.adaptris.net/nexus/content/groups/public"
resolvers += "adaptris-releases" at "https://nexus.adaptris.net/nexus/content/repositories/releases"
resolvers += "adaptris-snapshots" at "https://nexus.adaptris.net/nexus/content/repositories/snapshots"

libraryDependencies ++= Seq(
   "com.adaptris" % "interlok-core" % "3.8-SNAPSHOT",
   "com.adaptris" % "interlok-core-apt" % "3.8-SNAPSHOT",
   "junit" % "junit" % "4.11" % "test" , 
   "com.adaptris" % "interlok-stubs" % "3.8-SNAPSHOT" % "test",
   "org.mockito" % "mockito-all" % "1.9.5" % "test"
)
