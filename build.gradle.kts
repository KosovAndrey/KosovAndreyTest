plugins {
    id("java")
}

group = "kosovandrey.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.14.0")
    implementation ("commons-io:commons-io:2.11.0")
}

tasks.test {
    useJUnitPlatform()
}