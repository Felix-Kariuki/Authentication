package com.flexcode.authenticationapp.domain.use_case

import com.flexcode.authenticationapp.data.remote.request.LoginRequest
import com.flexcode.authenticationapp.domain.model.LoginResult
import com.flexcode.authenticationapp.domain.repository.LoginRepository

class LoginUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(
        email:String,
        password:String
    ):LoginResult {

        val emailError = if (email.isBlank()) "Username cannot be blank" else null
        val passwordError = if (password.isBlank()) "Password cannot be blank" else null

        if (emailError != null){
            return LoginResult(
                emailError = emailError
            )
        }

        if (passwordError!=null){
            return LoginResult(
                passwordError = passwordError
            )
        }

        val loginRequest = LoginRequest(
            email = email.trim(),
            password = password.trim()
        )

        return LoginResult(
            result = repository.login(loginRequest)
        )
    }
}