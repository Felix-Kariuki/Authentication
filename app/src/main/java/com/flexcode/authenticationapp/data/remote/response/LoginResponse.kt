package com.flexcode.authenticationapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token : String
)
