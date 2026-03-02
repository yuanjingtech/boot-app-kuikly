plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.2").apply(false)
    id("com.android.library").version("7.4.2").apply(false)
    kotlin("android").version("2.1.21").apply(false)
    kotlin("multiplatform").version("2.1.21").apply(false)
    id("com.google.devtools.ksp").version("2.1.21-2.0.1").apply(false)
    id("org.jetbrains.compose").version("1.7.3").apply(false)
    kotlin("plugin.compose").version("2.1.21").apply(false)
    id("com.vanniktech.maven.publish").version("0.36.0").apply(false)
}

buildscript {
    dependencies {
        classpath(BuildPlugin.kuikly)
    }
}
subprojects {
    group = "com.yuanjingtech.boot.app.kuikly"
    version = "1.0.0-alpha.1"
    plugins.withId("maven-publish") {
        configure<PublishingExtension> {
            publications {
                create<MavenPublication>("maven") {
                    groupId = group.toString()
                    artifactId = name
                    version = version.toString()
                }
            }
        }
    }
    plugins.withId("com.vanniktech.maven.publish") {
        configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
            publishToMavenCentral()
            signAllPublications()

            coordinates(group.toString(), name, version.toString())

            pom {
                name = "yuanjingtech's boot library for kuikly app"
                description = "yuanjingtech's boot library for kuikly app."
                inceptionYear = "2025"
                url = "https://github.com/yuanjingtech/boot-app-kuikly"
                licenses {
                    license {
                        name = "MIT License"
                        url = "https://github.com/yuanjingtech/boot-app-kmp/blob/main/LICENSE"
                        distribution = "https://github.com/yuanjingtech/boot-app-kmp/blob/main/LICENSE"
                    }
                }
                developers {
                    developer {
                        id = "yuanjingtech"
                        name = "yuanjingtech"
                        url = "https://github.com/yuanjingtech"
                    }
                }
                scm {
                    url = "https://github.com/yuanjingtech/boot-app-kuikly"
                    connection = "scm:git:git://github.com/yuanjingtech/boot-app-kuikly.git"
                    developerConnection = "scm:git:ssh://git@github.com/yuanjingtech/boot-app-kuikly.git"
                }
            }
        }
    }
}