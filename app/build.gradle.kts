plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.wufy"
    compileSdk = 34
    buildFeatures {
        viewBinding{
            enable = true
        }
    }
    defaultConfig {
        applicationId = "com.example.wufy"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-ads:22.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.28")
        val roomVersion = "2.6.1"

        implementation("androidx.room:room-runtime:$roomVersion")
        annotationProcessor("androidx.room:room-compiler:$roomVersion")

        // To use Kotlin annotation processing tool (kapt)
        kapt("androidx.room:room-compiler:$roomVersion")
    implementation ("com.github.bumptech.glide:glide:4.16.0")

}