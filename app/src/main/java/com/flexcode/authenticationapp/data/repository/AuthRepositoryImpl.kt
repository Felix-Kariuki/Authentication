package com.flexcode.authenticationapp.data.repository

import android.content.SharedPreferences
import com.flexcode.authenticationapp.data.local.AuthPreferences
import com.flexcode.authenticationapp.data.remote.ApiService
import com.flexcode.authenticationapp.data.remote.request.AuthRequest
import com.flexcode.authenticationapp.domain.repository.AuthRepository
import com.flexcode.authenticationapp.util.Resource
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val apiService: ApiService,
    private val preferences: AuthPreferences

) : AuthRepository{
    override suspend fun login(loginRequest: AuthRequest): Resource<Unit> {
       return try {
           val response = apiService.loginUser(loginRequest)
           preferences.saveAuthToken(response.token)
           Resource.Success(Unit)
       }catch (e: IOException){
           Resource.Error("${e.message}")
       }catch (e: HttpException){
           Resource.Error("${e.message}")
       }
    }

    override suspend fun register(registerRequest: AuthRequest): Resource<Unit> {
        return try {
           val response = apiService.registerUser(registerRequest)
            preferences.saveAuthToken(response.token)
            Resource.Success(Unit)
        }catch (e: IOException){
            Resource.Error("${e.message}")
        }catch (e: HttpException){
            Resource.Error("${e.message}")
        }
    }


}