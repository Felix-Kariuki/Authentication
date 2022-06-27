package com.flexcode.authenticationapp.data.repository

import com.flexcode.authenticationapp.data.local.AuthPreferences
import com.flexcode.authenticationapp.data.remote.ApiService
import com.flexcode.authenticationapp.data.remote.request.LoginRequest
import com.flexcode.authenticationapp.domain.repository.LoginRepository
import com.flexcode.authenticationapp.util.Resource
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import java.io.IOException

class LoginRepositoryImpl(
    private val apiService: ApiService,
    private val preferences: AuthPreferences
) : LoginRepository{
    override suspend fun login(loginRequest: LoginRequest): Resource<Unit> {
       return try {
           val response =apiService.loginUser(loginRequest)
           preferences.saveLoginToken(response.token)
           Resource.Success(Unit)
       }catch (e: IOException){
           Resource.Error("${e.message}")
       }catch (e: HttpException){
           Resource.Error("${e.message}")
       }
    }

    override suspend fun autoLogin(): Resource<Unit> {
        val token = preferences.getLoginToken.first()
        return if (token != ""){
            Resource.Success(Unit)
        }else{
            Resource.Error("Session expired try to login again")
        }
    }
}