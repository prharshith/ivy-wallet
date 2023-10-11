plugins {
    id("org.jetbrains.kotlinx.kover")
}

koverReport {
    defaults {
        mergeWith("debug")

        filters {
            excludes {
                annotatedBy("Composable")
            }
        }
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    finalizedBy(tasks.getByName("koverHtmlReport"))
}