plugins {
    id("kotlin")
    id("java-library")
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Logs.timber)

    implementation(project(":data"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}