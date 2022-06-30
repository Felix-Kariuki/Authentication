package com.flexcode.authenticationapp.data.remote.request

import com.google.gson.annotations.SerializedName

data class AuthRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)
