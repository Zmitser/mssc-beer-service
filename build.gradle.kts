import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.1.9.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.2.71"
    kotlin("kapt") version "1.2.71"
    kotlin("plugin.spring") version "1.2.71"
}

group = "by.zmitser"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}
repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    api("com.github.pozo.mapstruct-kotlin:mapstruct-kotlin:1.3.0.Beta2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging:1.7.6")
    implementation("org.mapstruct:mapstruct:1.3.1.Final")
    kapt("com.github.pozo.mapstruct-kotlin:mapstruct-kotlin-processor:1.3.0.Beta2")
    kapt("org.mapstruct:mapstruct-processor:1.3.1.Final")
    implementation("com.h2database:h2")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.mockito:mockito-junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("junit", "junit")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform()
}