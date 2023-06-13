plugins {
    id("java")
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

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}