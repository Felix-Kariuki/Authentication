package com.flexcode.authenticationapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("token")
    val token : String
)
