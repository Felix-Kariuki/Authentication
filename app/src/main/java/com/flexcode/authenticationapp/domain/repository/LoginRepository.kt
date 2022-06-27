package com.flexcode.authenticationapp.domain.repository

import com.flexcode.authenticationapp.data.remote.request.LoginRequest
import com.flexcode.authenticationapp.util.Resource

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest):Resource<Unit>
    suspend fun autoLogin(): Resource<Unit>
}