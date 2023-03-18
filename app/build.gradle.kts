import AppDependencies.compose

plugins {
    id(Plugins.APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)

    id(Plugins.DAGGER_HILT_PLUGIN)
    id(Plugins.SAFEARGS)
    kotlin(Plugins.KOTLIN_KAPT)
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion
    namespace = AppConfig.applicationId

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk =  AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
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
        jvmTarget = Versions.JVM_TARGET
    }
    kapt {
        correctErrorTypes = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }
}

dependencies {
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)

    compose()
    daggerHilt()
    room()

    implementation(AppDependencies.presentation)
    implementation(AppDependencies.retrofit)
    implementation(AppDependencies.ktx)
    implementation(AppDependencies.appAndroidLibraries)
    implementation(AppDependencies.remoteLibraries)
    implementation(AppDependencies.domainLibraries)
    implementation(AppDependencies.androidLibraries)
}