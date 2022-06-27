package com.flexcode.authenticationapp.domain.model

import com.flexcode.authenticationapp.data.models.Data
import com.flexcode.authenticationapp.data.models.Support
import com.google.gson.annotations.SerializedName

data class User(
    var data: Data,
    var support: Support
)