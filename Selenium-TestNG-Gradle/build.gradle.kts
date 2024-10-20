plugins {
    id("java")
}

group = "org.gradleexample"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.25.0")
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.10.2")
    // https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")
}

tasks.test {
    useTestNG() {
        suites("src/test/resources/TestNG.xml");
    }
}