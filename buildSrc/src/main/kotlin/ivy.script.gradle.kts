plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("org.jetbrains.kotlinx.kover")
}

kotlin {
    sourceSets.all {
        kotlin.srcDir("build/generated/ksp/$name/kotlin")
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs += "-XXLanguage:+ContextReceivers"
    }
}

dependencies {
    implementation(libs.bundles.arrow)
    implementation(libs.bundles.kotlin)

    implementation(catalog.library("kotlinx-serialization-json"))
    testImplementation(libs.bundles.testing)
}