// This is how you "import" a binary plugin
apply(plugin="base")

tasks.register<Copy>("myCopyTask") {
    from(layout.projectDirectory.dir("src"))
    into(layout.buildDirectory.dir("docs"))
    include("**/*md")
    includeEmptyDirs = false
}

tasks.register<Zip>("zipDocs") {
    dependsOn(tasks["myCopyTask"])
    from(layout.buildDirectory.dir("docs"))
    archiveFileName.set("docs.zip")
    destinationDirectory.set(layout.buildDirectory.dir("dist"))
}