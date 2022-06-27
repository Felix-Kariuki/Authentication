package com.flexcode.authenticationapp.util

import androidx.datastore.preferences.core.stringSetPreferencesKey

object Constants {
    const val BASE_URL = "https://reqres.in/"
    const val AUTH_PREFERENCES = "AUTH_PREF"
    val AUTH_KEY = stringSetPreferencesKey("auth_key")
    val USER_INFO = stringSetPreferencesKey("user_data")
}