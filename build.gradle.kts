import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "com.hayate"
version = "1.0.0"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

allprojects {

    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "application")

    repositories {
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/groups/public")
            url = uri("https://kotlin.bintray.com/ktor")
            url = uri("https://plugins.gradle.org/m2/")
        }
        mavenCentral()
        jcenter()
        flatDir { dirs("libs") }
    }
}

subprojects {

    dependencies {
        ext {
            set("kotlinVersion", "1.4.32")
            set("koinVersion", "2.1.0")
            set("ktorVersion", "1.5.3")
            // log
            set("logbackVersion", "1.2.1")
            // Sql
            set("mysqlVersion", "8.0.18")
            set("exposedVersion", "0.31.1")
            //
            set("hikariCpVersion", "4.0.3")
            set("flywayVersion", "7.7.3")
            set("ktorFlywayVersion", "1.2.2")
        }

        implementation("mysql:mysql-connector-java:${ext.get("mysqlVersion")}")

        implementation(kotlin("stdlib-jdk8"))

        implementation("io.ktor:ktor-server-netty:${ext.get("ktorVersion")}")
        implementation("io.ktor:ktor-server-core:${ext.get("ktorVersion")}")
        implementation("io.ktor:ktor-gson:${ext.get("ktorVersion")}")
        implementation("io.ktor:ktor-locations:${ext.get("ktorVersion")}")

        implementation("org.koin:koin-ktor:${ext.get("koinVersion")}")

        implementation("ch.qos.logback:logback-classic:${ext.get("logbackVersion")}")

        testImplementation("io.ktor:ktor-server-tests:${ext.get("ktorVersion")}")

    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "1.8"
            }
        }
        withType<Test> {
            useJUnitPlatform()
        }
    }
}


