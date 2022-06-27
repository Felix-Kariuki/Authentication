package com.flexcode.authenticationapp.domain.model

import com.flexcode.authenticationapp.util.Resource

data class LoginResult(
    val passwordError: String? = null,
    val emailError : String? = null,
    val result: Resource<Unit>? = null
)