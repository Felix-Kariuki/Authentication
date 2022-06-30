package com.flexcode.authenticationapp.data.remote

import com.flexcode.authenticationapp.data.remote.request.AuthRequest
import com.flexcode.authenticationapp.data.remote.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/login")
    suspend fun loginUser(
        @Body loginRequest: AuthRequest
    ) : AuthResponse


    @POST("api/register")
    suspend fun registerUser(
        @Body registerRequest: AuthRequest
    ) : AuthResponse


}