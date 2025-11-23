plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.madassignment2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.madassignment2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Add vectorDrawables support for better resource handling
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    
    buildTypes {
        debug {
            isMinifyEnabled = false
            // Disable resource shrinking in debug to avoid AAPT issues
            isShrinkResources = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Disable resource shrinking if having AAPT issues
            isShrinkResources = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    
    lint {
        abortOnError = false
        checkReleaseBuilds = false
        disable += listOf(
            "MissingInflatedId",
            "HardcodedText",
            "ContentDescription",
            "UnusedResources"
        )
    }
    
    // Add packaging options to handle resource extraction more gracefully
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            // Handle tflite files if needed
            pickFirsts += "**/*.so"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    
    // CircleImageView for circular profile pictures
    implementation("de.hdodenhof:circleimageview:3.1.0")
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
