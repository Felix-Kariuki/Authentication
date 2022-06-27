package com.flexcode.authenticationapp.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.flexcode.authenticationapp.util.Constants.AUTH_KEY
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthPreferences(
    private val dataStore: DataStore<Preferences>,
    private val gson: Gson
) {

    suspend fun saveLoginToken(loginToken:String){
        dataStore.edit { pref->
            pref[AUTH_KEY] = setOf(loginToken)
        }
    }

    val getLoginToken : Flow<String> = dataStore.data.map { pref->
        (pref[AUTH_KEY]?: "").toString()
    }
}