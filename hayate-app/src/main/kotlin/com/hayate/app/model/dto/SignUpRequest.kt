package com.hayate.app.model.dto

/**
 * @author Flame
 * @date 2020-05-09 16:50
 */

data class SignUpRequest(
    val account: String?,
    val password: String?,
    val verificationCode: String?
)