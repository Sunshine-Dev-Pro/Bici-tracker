

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

    const val junit = "junit:junit:4.13"

    object Logs {
        private const val version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object Navigation {
        private const val version = "5.1.0"
        const val cicerone = "ru.terrakok.cicerone:cicerone:$version"
    }

    object LeakCanary {
        private const val version = "2.2"
        const val android = "com.squareup.leakcanary:leakcanary-android:$version"
    }
    object Google {
        const val material = "com.google.android.material:material:1.1.0"
    }

    object Kotlin {
        private const val version = "1.3.71"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val core = "androidx.core:core-ktx:1.2.0"
    }

    object RxJava {
        private const val version = "2.2.0"
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.18"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
        const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:2.1.1"
        const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:3.1.0"
        const val rxBindingCore = "com.jakewharton.rxbinding3:rxbinding-core:3.1.0"
        const val rxBindingAppCompat = "com.jakewharton.rxbinding3:rxbinding-appcompat:3.1.0"
        const val rxBindingMaterial = "com.jakewharton.rxbinding3:rxbinding-appcompat:3.1.0"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val browser = "androidx.browser:browser:1.0.0"
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

        const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"

        const val preference = "androidx.preference:preference:1.1.0"

        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"

        const val coreKtx = "androidx.core:core-ktx:1.2.0-rc01"

        object Lifecycle {
            private const val version = "2.2.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Room {
            private const val version = "2.2.4"
            const val common = "androidx.room:room-common:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val rxjava2 = "androidx.room:room-rxjava2:$version"
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
}
