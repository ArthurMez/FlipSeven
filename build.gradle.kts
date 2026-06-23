plugins {
    kotlin("jvm") version "2.3.0"
    id("org.openjfx.javafxplugin") version "0.1.0"
    application
}

group = "iut.info1"
version = "1.0"

repositories {
    maven {
        url = uri("http://nexus.dep-info.iut-nantes.univ-nantes.prive/repository/public/")
        isAllowInsecureProtocol = true
    }
    mavenCentral()
}

javafx {
    version = "17"
    modules("javafx.controls", "javafx.graphics")
}

dependencies {
    // Bibliothèque Flip7 fournie sous forme de .jar (cf. libs/iut.info1.flip7-<version>.jar).
    implementation(fileTree("libs") { include("iut.info1.flip7-*.jar") })

    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.11.4")
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

application {
    mainClass.set("iut.info1.flip7.MainKt")
}

tasks.test {
    useJUnitPlatform()
}
