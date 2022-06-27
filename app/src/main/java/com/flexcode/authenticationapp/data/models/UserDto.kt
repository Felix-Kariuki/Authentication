package com.flexcode.authenticationapp.data.models

import com.google.gson.annotations.SerializedName

data class UserDto(

    @SerializedName("data")
    var data: Data? = Data(),
    @SerializedName("support")
    var support: Support? = Support()

)