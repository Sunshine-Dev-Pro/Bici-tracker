buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Google.googleServices)
        classpath(Libs.Firebase.firebaseCrashlyticsGradle)
        classpath(Libs.AndroidX.Navigation.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://maven.google.com") }
        mavenCentral()
        maven {
            url = uri("http://www.idescout.com/maven/repo/")
            name = ("IDEScout, Inc.")
        }
    }
}


val clean by tasks.creating(Delete::class) {
    delete = setOf(rootProject.buildDir)
}