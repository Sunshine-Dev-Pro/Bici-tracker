plugins {
    id("kotlin")
    id("java-library")
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Logs.timber)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}