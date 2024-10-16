plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.makeappssimple.abhimanyu.coroutinesplayground.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.makeappssimple.abhimanyu.coroutinesplayground.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"

        freeCompilerArgs += listOf(
            // Explicit API mode
            "-Xexplicit-api=strict",
        )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.test.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.coroutines.android)

    // Coroutines test
    testImplementation(libs.coroutines.test)
    androidTestImplementation(libs.coroutines.test)

    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.android)
    // implementation(libs.hilt.work)
    ksp(libs.hilt.compiler)

    implementation(libs.ksp)

    // Testing

    // JUnit
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit)

    // Mockito kotlin
    testImplementation(libs.mockito.kotlin)
    androidTestImplementation(libs.mockito.kotlin)

    // Coroutines test
    testImplementation(libs.coroutines.test)
    androidTestImplementation(libs.coroutines.test)

    // AndroidX core test
    testImplementation(libs.core.testing)
    androidTestImplementation(libs.core.testing)

    // Turbine
    testImplementation(libs.turbine)
    androidTestImplementation(libs.turbine)

    // Hilt testing
    testImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.hilt.android.testing)
    kspTest(libs.hilt.compiler)
    kspAndroidTest(libs.hilt.compiler)

    // Jetpack compose UI tests
    androidTestImplementation(libs.compose.ui.test.junit4)

    // Jetpack compose UI tests manifest - Needed for createComposeRule, but not createAndroidComposeRule
    debugImplementation(libs.compose.ui.test.manifest)
}
