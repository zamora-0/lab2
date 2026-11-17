plugins {
    application
}

dependencies {
    implementation(project(":module-core"))
    implementation("org.fusesource.jansi:jansi:2.4.2")
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "by.gstu.project.cli.App"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register("my-task") {
    doLast {
        println("This is my task")
    }
}
