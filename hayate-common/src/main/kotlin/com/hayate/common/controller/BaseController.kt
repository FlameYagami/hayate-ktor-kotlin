package com.hayate.common.controller

import io.ktor.application.*
import org.koin.core.KoinComponent
import org.koin.core.logger.Logger

open class BaseController (
    protected val application: Application,
    protected val log: Logger
): KoinComponent {

}