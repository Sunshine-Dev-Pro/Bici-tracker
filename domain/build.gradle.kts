plugins {
    id("kotlin")
    id("java-library")
    kotlin("jvm")
}

kotlin { // type is KotlinJvmProjectExtension
    experimental.coroutines = org.jetbrains.kotlin.gradle.dsl.Coroutines.ENABLE
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.android)

    api(Libs.AndroidX.Paging.common)
    implementation(Libs.AndroidX.Paging.runtime)

    implementation(Libs.Logs.timber)

    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.kotlinJUnit)
    testImplementation(Libs.Test.mockito)
    testImplementation(Libs.Coroutines.test)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}