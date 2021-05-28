package com.hayate.common

import org.koin.core.logger.Logger
import org.koin.core.logger.PrintLogger
import org.koin.dsl.module

val commonModule = module(createdAtStart = true) {
    single<Logger> { PrintLogger() }
}