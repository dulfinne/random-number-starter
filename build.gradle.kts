plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    kotlin("kapt") version "1.5.31"
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.dulfinne"
version = "0.0.1-SNAPSHOT"
description = "random-number-starter"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}


tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.register<Copy>("copySpringMetadata") {
//    from("$buildDir/classes/kotlin/main/META-INF/spring-configuration-metadata.json")
//    into("$buildDir/resources/main/META-INF")
//    include("spring-configuration-metadata.json")
//}
//
//tasks.named("processResources") {
//    dependsOn("copySpringMetadata")
//}
