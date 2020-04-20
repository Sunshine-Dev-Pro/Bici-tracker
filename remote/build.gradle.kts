plugins {
    id("kotlin")
    id("java-library")
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Logs.timber)

    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.kotlinJUnit)
    testImplementation(Libs.Test.mockito)
    testImplementation(Libs.Coroutines.test)

    implementation(project(":data"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}