plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly("com.android.tools.lint:lint-api:30.1.0-alpha03") // = agp + 23.0.0
    testImplementation("com.android.tools.lint:lint-tests:30.1.0-alpha03")
}
