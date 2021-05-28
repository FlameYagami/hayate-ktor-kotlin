group = "com.hayate.app"
description = "应用模块"

dependencies {
    implementation(project(":hayate-common"))

    implementation("com.viartemev:ktor-flyway-feature:${ext.get("ktorFlywayVersion")}")
}