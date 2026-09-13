plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}
rootProject.name = "DiceRoller"

// Include the engine subproject so `project(":engine")` works
include(":engine")