import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id("com.android.application")

    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services") apply false
    id("androidx.navigation.safeargs.kotlin")
}

repositories {
    maven("https://maven.google.com")
    maven("https://jitpack.io")
    mavenCentral()
}

android {
    compileSdkVersion(Build.compileSdk)

    defaultConfig {
        applicationId = Build.appId
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.compileSdk)
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dexOptions {
        maxProcessCount = 2
        javaMaxHeapSize = "2g"
    }

    signingConfigs {
        getByName("debug") {
            // add debug keystore properties here
        }

        create("release") {
            // add release keystore properties here
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            firebaseCrashlytics {
                mappingFileUploadEnabled = false
            }
        }

        named("release") {
            isDebuggable = false
            isMinifyEnabled = false
            isShrinkResources = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    flavorDimensions("default")
    productFlavors {
        create("default") {
            applicationId = defaultConfig.applicationId
            versionCode = Build.versionCode
            versionName = Build.versionName
            matchingFallbacks = mutableListOf("production")
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("main").res.srcDirs(
            listOf(
                "src/main/res/layout/activity",
                "src/main/res/layout/fragment",
                "src/main/res/layout/item",
                "src/main/res/layout/widget",
                "src/main/res/layout",
                "src/main/res"
            )
        )
    }

    //set custom name to apk file
    applicationVariants.all {
        val variant = this
        variant.outputs
            .map { it as BaseVariantOutputImpl }
            .forEach { output ->
                output.outputFileName =
                    "${variant.productFlavors.first().applicationId}" +
                    "-v${variant.productFlavors.first().versionName}" +
                    "_build${variant.productFlavors.first().versionCode}" +
                    "-${variant.buildType.name}" +
                    ".apk"
            }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kapt.correctErrorTypes = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Kotlin.core)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.constraintlayout)
    implementation(Libs.Google.material)

    // Navigation
    implementation(Libs.AndroidX.Navigation.fragment)
    implementation(Libs.AndroidX.Navigation.ui)

    // Google Maps
    implementation(Libs.Google.googleMaps)

    // Firebase
    implementation(Libs.Firebase.firebaseCore)
    implementation(Libs.Firebase.firebasePerformance)
    implementation(Libs.Firebase.firebaseAnalytics)
    implementation(Libs.Firebase.crashlytics)

    // Koin
    implementation(Libs.DI.koinScope)
    implementation(Libs.DI.koinViewModel)
    testImplementation(Libs.DI.koinTest)

    debugImplementation(Libs.Logs.timber)

    debugImplementation(Libs.LeakCanary.android)

    androidTestImplementation(Libs.junit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":device"))
    implementation(project(":cache"))
    implementation(project(":remote"))
}

apply(mapOf("plugin" to "com.google.gms.google-services"))
