package com.flexcode.authenticationapp.data.remote

import com.flexcode.authenticationapp.data.remote.request.LoginRequest
import com.flexcode.authenticationapp.data.remote.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/login")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ) : LoginResponse


}