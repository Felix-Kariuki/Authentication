package com.flexcode.authenticationapp.domain.use_case

import com.flexcode.authenticationapp.domain.repository.LoginRepository
import com.flexcode.authenticationapp.util.Resource

class AutoLoginUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(): Resource<Unit>{
        return repository.autoLogin()
    }
}