package com.flexcode.authenticationapp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexcode.authenticationapp.common.TextFieldState
import com.flexcode.authenticationapp.common.UiEvents
import com.flexcode.authenticationapp.destinations.HomeScreenDestination
import com.flexcode.authenticationapp.domain.use_case.LoginUseCase
import com.flexcode.authenticationapp.presentation.AuthState
import com.flexcode.authenticationapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private var _loginState  = mutableStateOf(AuthState())
    val loginState: State<AuthState> = _loginState

    private val  _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _emailState = mutableStateOf(TextFieldState())
    val emailState: State<TextFieldState> = _emailState

    fun setEmail(value:String){
        _emailState.value = emailState.value.copy(text = value)
    }

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState: State<TextFieldState> = _passwordState

    fun setPassword(value:String){
        _passwordState.value = passwordState.value.copy(text = value)
    }

    fun loginUser(){
        viewModelScope.launch {
            _loginState.value = loginState.value.copy(isLoading = false)

            val loginResult = loginUseCase(
                email = emailState.value.text,
                password = passwordState.value.text
            )

            _loginState.value = loginState.value.copy(isLoading = false)

            if (loginResult.emailError != null){
                _emailState.value=emailState.value.copy(error = loginResult.emailError)
            }
            if (loginResult.passwordError != null){
                _passwordState.value = passwordState.value.copy(error = loginResult.passwordError)
            }

            when(loginResult.result){
                is Resource.Success->{
                    _eventFlow.emit(
                       UiEvents.NavigateEvent(HomeScreenDestination.route)
                    )
                }
                is Resource.Error->{
                    UiEvents.SnackbarEvent(
                        loginResult.result.message ?: "Error Occurred"
                    )
                }
                else -> {

                }
            }
        }
    }
}