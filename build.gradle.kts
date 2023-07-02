plugins {
    id("java")
    id("io.freefair.lombok") version "8.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    implementation("io.github.openfeign:feign-core:12.3")
    implementation("io.github.openfeign:feign-okhttp:12.3")
    implementation("io.github.openfeign:feign-gson:12.3")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.4")


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.0")
}

tasks.test {
    useJUnitPlatform()
}