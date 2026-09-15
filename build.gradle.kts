plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Explicitly use the stdlib that matches the Kotlin plugin/compiler used by the build.
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
    implementation(project(":engine"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    // Use a kotlinx-serialization version compatible with Kotlin 1.9
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}

kotlin {
    jvmToolchain(21) // modern default
}



application {
    mainClass.set("MainKt")
}

sourceSets {
    named("main") {
        kotlin.srcDirs("src/main/kotlin")
        resources.srcDirs("src/main/kotlin")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}

// Prevent transitive dependencies from pulling an incompatible Kotlin stdlib (e.g. 2.x)
configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
        force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.24")
    }
}
