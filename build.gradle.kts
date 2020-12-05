plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.20"
}

group = "com.adriel-m"
version = "1.0-SNAPSHOT"
var koinVersion= "3.0.0-alpha-4"

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
}
