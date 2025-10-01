import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val packageVersion = "1.3.0"

plugins {
  id("java")
  kotlin("jvm") version "1.9.20"
  id("com.vanniktech.maven.publish") version "0.28.0"
}

group = "at.deckweiss"
version = packageVersion
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
}

tasks.test {
  useJUnitPlatform()
  testLogging {
    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
  }
}

tasks.withType<KotlinCompile> {
  compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
}

mavenPublishing {
  coordinates(
    groupId = "at.deckweiss",
    artifactId = "essentials",
    version = packageVersion
  )

  pom {
    name.set("Deckweiss Essentials")
    description.set("Library for basic extensions and utilities for Kotlin and Spring boot")
    url.set("https://github.com/deckweiss-gmbh/kotlin-essentials")
    inceptionYear.set("2023")

    licenses {
      license {
        name.set("The Apache License, Version 2.0")
        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
      }
    }

    developers {
      developer {
        id.set("klausbetz")
        name.set("Klaus Betz")
        url.set("https://www.deckweiss.at")
      }
    }

    scm {
      url.set("https://github.com/deckweiss-gmbh/kotlin-essentials")
    }
  }

  publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
  signAllPublications()
}
