plugins {
    kotlin("jvm") version "1.9.0"
    id("me.champeau.gradle.jmh") version "0.5.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

jmh {
    threads = 1
    fork = 1
    warmupIterations = 1
    iterations = 1
}