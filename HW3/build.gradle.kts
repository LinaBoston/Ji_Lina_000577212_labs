plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.stefanbratanov:jvm-openai:0.11.0")
}

application {
    mainClass.set("org.example.App") // Use `set` with Kotlin DSL
}