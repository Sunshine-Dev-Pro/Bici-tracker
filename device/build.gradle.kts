plugins {
    id("com.android.library")

    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

android {

    compileSdkVersion(Build.compileSdk)

    defaultConfig {
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.compileSdk)
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_7
        targetCompatibility = JavaVersion.VERSION_1_7
    }

}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.android)
    implementation(Libs.Coroutines.coroutinesPlayServices)

    implementation(Libs.Google.googleLocation)

    implementation(Libs.Logs.timber)

    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.kotlinJUnit)
    testImplementation(Libs.Test.mockito)
    testImplementation(Libs.Coroutines.test)

    implementation(project(":data"))
}
