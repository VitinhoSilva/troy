import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	id("jacoco")
	id("org.kordamp.gradle.jacoco") version "0.54.0"
	id("org.barfuin.gradle.jacocolog") version "3.1.0"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.jpa") version "1.9.22"
}

group = "com.jvprojetos17"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.hibernate:hibernate-validator:8.0.0.Final")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("org.postgresql:postgresql")
}

jacoco {
	toolVersion = "0.8.9"
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
	systemProperty("spring.profiles.active", "test")
}

tasks.withType<Test> {
	configure<JacocoTaskExtension> {
		excludes = listOf("**/Application*")
	}
}

tasks.register("checkCoverage") {
	dependsOn("test", "jacocoTestReport")
	doLast {
		val minCoverage = System.getenv("MIN_COVERAGE")?.toDoubleOrNull() ?: 90.0
		val coverageReport = file(layout.buildDirectory.dir("reports/jacoco/test/jacocoTestReport.xml").get())

		if (!coverageReport.exists()) {
			error("Jacoco coverage report not found. Make sure Jacoco is properly configured.")
		}

		val coveredPercentage = coverageReport.readLines().find { it.contains("LINE") }?.substringAfter("covered=\"")?.substringBefore("\"")?.toDoubleOrNull() ?: 0.0

		if (coveredPercentage >= minCoverage) {
			println("Test coverage is above or equal to the minimum required coverage of $minCoverage%")
		} else {
			error("Test coverage is below the minimum required coverage of $minCoverage%. Build failed.")
		}
	}
}

tasks.named("check") {
	finalizedBy("jacocoTestReport")
}

tasks.named<Jar>("jar") {
	enabled = false
}

buildscript {
	repositories {
		mavenCentral()
	}
}


