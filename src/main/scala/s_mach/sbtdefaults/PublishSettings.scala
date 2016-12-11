package s_mach.sbtdefaults

import sbt._
import sbt.Keys._

trait PublishSettings extends ProjectSettings {
  override def projectSettings : Seq[Setting[_]] = super.projectSettings ++ Seq(
    publishMavenStyle := true,
    pomIncludeRepository := { _ => false },
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    pomExtra := (
      <url>https://github.com/S-Mach/s_mach.
        {name.value}
      </url>
        <licenses>
          <license>
            <name>MIT</name>
            <url>http://opensource.org/licenses/MIT</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:S-Mach/s_mach.
            {name.value}
            .git</url>
          <connection>scm:git:git@github.com:S-Mach/s_mach.
            {name.value}
            .git</connection>
          <developerConnection>scm:git:git@github.com:S-Mach/s_mach.
            {name.value}
            .git</developerConnection>
        </scm>
        <developers>
          <developer>
            <id>lancegatlin</id>
            <name>Lance Gatlin</name>
            <email>lance.gatlin@gmail.com</email>
            <organization>S-Mach</organization>
            <organizationUrl>http://s-mach.net</organizationUrl>
          </developer>
        </developers>
    )
  )
}