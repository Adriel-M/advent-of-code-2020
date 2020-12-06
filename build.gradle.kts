import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.20"
    id("org.jlleitschuh.gradle.ktlint") version "9.4.0"
}

group = "com.adriel-m"
version = "1.0-SNAPSHOT"
var koinVersion = "3.0.0-alpha-4"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/ekito/koin")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.koin:koin-core:$koinVersion")
    implementation("org.koin:koin-core-ext:$koinVersion")

    testImplementation("org.koin:koin-test:$koinVersion")
    testImplementation("org.assertj:assertj-core:3.11.1")
}

ktlint {
    verbose.set(true)
    outputToConsole.set(true)
    coloredOutput.set(true)
    reporters {
        reporter(ReporterType.CHECKSTYLE)
        reporter(ReporterType.JSON)
        reporter(ReporterType.HTML)
    }
    filter {
        exclude("**/style-violations.kt")
    }
}
