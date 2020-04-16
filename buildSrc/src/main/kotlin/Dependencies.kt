object Build {
    const val compileSdk = 29
    const val buildTools = "29.0.3"
    const val minSdk = 22
    const val versionCode = 1
    const val versionName = "1.0"
    const val appId = "com.sunshinedevpro.bicitracker"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.0.0-beta04"

    object Logs {
        private const val version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object LeakCanary {
        private const val version = "2.2"
        const val android = "com.squareup.leakcanary:leakcanary-android:$version"
    }

    object Firebase {
        private const val firebaseCoreVersion = "17.2.2"
        private const val firebasePerfVersion = "19.0.5"
        private const val firebaseMessagingVersion = "20.1.4"
        private const val crashlyticsVersion = "2.10.1"
        private const val analyticsVersion = "17.0.0-beta03"
        private const val crashlyticsPluginVersion = "2.0.0-beta03"


        const val firebaseCore = "com.google.firebase:firebase-core:$firebaseCoreVersion"
        const val firebasePerformance = "com.google.firebase:firebase-perf:$firebasePerfVersion"
        const val crashlytics = "com.crashlytics.sdk.android:crashlytics:$crashlyticsVersion"
        const val firebaseAnalytics = "com.google.firebase:firebase-crashlytics:$analyticsVersion"
        const val fcm = "com.google.firebase:firebase-messaging:$firebaseMessagingVersion"
        const val firebaseCrashlyticsGradle =
            "com.google.firebase:firebase-crashlytics-gradle:$crashlyticsPluginVersion"
    }

    object Google {
        private const val googlePlayServicesVersion = "17.0.0"
        const val googleMaps = "com.google.android.gms:play-services-maps:$googlePlayServicesVersion"

        private const val playServicesVersion = "4.3.3"
        const val googleServices = "com.google.gms:google-services:$playServicesVersion"

        const val googleLocation = "com.google.android.gms:play-services-location:$googlePlayServicesVersion"

        const val material = "com.google.android.material:material:1.1.0"
    }

    object Kotlin {
        const val kotlinVersion = "1.3.72"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$kotlinVersion"
        const val core = "androidx.core:core-ktx:1.2.0"
    }

    object Coroutines {
        private const val version = "1.3.5"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        const val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0-beta01"
        const val collection = "androidx.collection:collection-ktx:1.1.0"
        const val palette = "androidx.palette:palette:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
        const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0-beta01"
        const val cardview = "androidx.cardview:cardview:1.0.0"

        object Navigation {
            private const val version = "2.2.1"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Fragment {
            private const val version = "1.2.2"
            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }

        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"

        const val coreKtx = "androidx.core:core-ktx:1.2.0"

        object Lifecycle {
            private const val version = "2.2.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Paging {
            private const val version = "2.1.2"
            const val common = "androidx.paging:paging-common-ktx:$version"
            const val runtime = "androidx.paging:paging-runtime-ktx:$version"
        }

        object Room {
            private const val version = "2.2.4"
            const val common = "androidx.room:room-common:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val gson = "com.google.code.gson:gson:2.8.5"
            const val testing = "androidx.room:room-testing:$version"
        }

        object Work {
            private const val version = "2.3.2"
            const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
        }
    }

    object Retrofit {
        private const val version = "2.7.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.4.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object DI {
        private const val koinVersion = "2.1.1"
        const val koinScope = "org.koin:koin-androidx-scope:$koinVersion"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:$koinVersion"
        const val koinTest = "org.koin:koin-test:$koinVersion"
    }

    object Test {
        private const val jUnitVersion = "4.13"
        private const val mockitoKotlinVersion = "2.2.0"
        private const val androidTestRunner = "androidx.test.ext:junit:1.1.1"
        private const val androidRunner = "androidx.test:runner:1.1.1"
        private const val espresso = "androidx.test.espresso:espresso-core:3.1.0"
        private const val androidSupportRunnerVersion = "1.1.1"
        private const val androidSupportRulesVersion = "1.1.1"
        private const val robolectricVersion = "3.8"

        const val junit = "junit:junit:$jUnitVersion"
        const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Kotlin.kotlinVersion}"
        const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${mockitoKotlinVersion}"

        // TODO: check this libs for testing
        /**
         * unitTesting = [
        kotlin:             "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version",
        kotlinTest:         "org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version",
        robolectric:        "org.robolectric:robolectric:$robolectric_version",
        junit:              "junit:junit:$junit_version",
        mockito:            "com.nhaarman:mockito-kotlin:$mockito_version",
        mockitoKotlin:      "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockito_kotlin_version",
        kluent:             "org.amshove.kluent:kluent:$kluent_version",
        archCoreTesting:    "androidx.arch.core:core-testing:$lifecycle_version",
        liveDataTesting:    "com.jraska.livedata:testing-ktx:$live_data_testing_version",
        coroutineTesting:   "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutine_testing_version",
        assertj:            "com.squareup.assertj:assertj-android:1.0.0",
        androidXTestCore:   "androidx.test:core:$androidx_test_core_version"
        ]

        testImplementation unitTestDependencies.junit
        testImplementation unitTestDependencies.kotlinTest
        testImplementation unitTestDependencies.mockitoKotlin
        testImplementation unitTestDependencies.coroutineTesting
        testImplementation unitTestDependencies.liveDataTesting
        testImplementation unitTestDependencies.archCoreTesting
         */
    }
}
