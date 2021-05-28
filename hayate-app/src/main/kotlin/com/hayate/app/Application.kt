package com.hayate.app

import com.hayate.common.commonModule
import com.hayate.common.config.DatabaseFactory
import com.viartemev.ktor.flyway.FlywayFeature
import com.viartemev.ktor.flyway.Migrate
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.util.*
import org.jetbrains.exposed.sql.Database
import org.koin.ktor.ext.Koin

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalAPI
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson {

        }
    }

    install(FlywayFeature) {
        dataSource = DatabaseFactory.create().apply {
            Database.connect(this)
            commands(Migrate)
        }
    }

    installKoin()
}

fun Application.installKoin() {
    install(Koin) {
        properties(mapOf("application" to this@installKoin))
        modules(appModule, commonModule)
    }
}