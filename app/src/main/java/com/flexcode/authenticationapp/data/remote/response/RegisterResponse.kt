package com.flexcode.authenticationapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("id")
    val id : String,
    @SerializedName("token")
    val token : String
)
