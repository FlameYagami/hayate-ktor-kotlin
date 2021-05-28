group = "com.hayate.common"
description = "通用模块"

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api("org.jetbrains.exposed:exposed-core:${ext.get("exposedVersion")}")
    api("org.jetbrains.exposed:exposed-dao:${ext.get("exposedVersion")}")
    api("org.jetbrains.exposed:exposed-jdbc:${ext.get("exposedVersion")}")
    api("org.jetbrains.exposed:exposed-jodatime:${ext.get("exposedVersion")}")

    implementation("com.zaxxer:HikariCP:${ext.get("hikariCpVersion")}")
    implementation("org.flywaydb:flyway-core:${ext.get("flywayVersion")}")
}