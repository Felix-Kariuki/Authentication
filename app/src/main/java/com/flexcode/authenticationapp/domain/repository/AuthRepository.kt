package com.flexcode.authenticationapp.domain.repository

import com.flexcode.authenticationapp.data.remote.request.AuthRequest
import com.flexcode.authenticationapp.util.Resource

interface AuthRepository {
    suspend fun login(loginRequest: AuthRequest):Resource<Unit>
    suspend fun register(registerRequest: AuthRequest):Resource<Unit>
}