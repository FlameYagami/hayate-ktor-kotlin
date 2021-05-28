package com.hayate.app.controller

import com.hayate.app.model.dto.SignInRequest
import com.hayate.app.model.dto.base.ApiResult
import com.hayate.app.service.UserService
import com.hayate.common.controller.BaseController
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.core.inject
import org.koin.core.logger.Logger

class LoginController(application: Application, log: Logger) : BaseController(application, log) {

    val userService: UserService by inject()

    init {
        application.routing {
            route("/v1") {
                signIn()
                singOut()
            }
        }
    }

    private fun Route.signIn() {
        patch("/sign-in") {
            val parameters = call.receiveParameters()
            val account = parameters["account"].toString()
            val password = parameters["password"].toString()
            val findFlag = userService.checkAccountExist(account)
            println(findFlag)
            call.respond(ApiResult.ok(SignInRequest(account, password)))
        }
    }

    private fun Route.singOut() {
        patch("/sign-out") {

        }
    }
}