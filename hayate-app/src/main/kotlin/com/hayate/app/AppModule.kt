package com.hayate.app

import com.hayate.app.controller.LoginController
import com.hayate.app.service.UserService
import io.ktor.application.*
import org.koin.core.scope.Scope
import org.koin.dsl.module

val appModule = module(createdAtStart = true) {
    // Controller
    single { LoginController(application = getApplication(), log = get()) }

    // Service
    single { UserService() }
}

fun Scope.getApplication() = getProperty("application") as Application