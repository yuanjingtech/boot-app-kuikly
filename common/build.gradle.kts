plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.google.devtools.ksp")
    id("com.tencent.kuikly-open.kuikly")
    id("org.jetbrains.compose")
    kotlin("plugin.compose")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release")
    }

    js(IR) {
        browser()
        binaries.executable()
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Compose UI Module for Testing and Demo"
        homepage = "Link to Compose App homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "composeApp"
            isStatic = true
            license = "MIT"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.tencent.kuikly-open:core:${Version.getKuiklyVersion()}")
                implementation("com.tencent.kuikly-open:core-annotations:${Version.getKuiklyVersion()}")
                implementation("com.tencent.kuikly-open:compose:${Version.getKuiklyVersion()}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.yuanjingtech.boot.app.kuikly.composeapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}
