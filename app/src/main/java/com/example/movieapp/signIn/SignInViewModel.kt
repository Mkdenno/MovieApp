package com.example.movieapp.signIn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel:ViewModel() {

    val _state= MutableStateFlow(SignInState())
    val state=_state.asStateFlow()

    fun onUserNameChange(newValue: String){
        _state.value=_state.value.copy(
            username=newValue
        )
        if (_state.value.username.isNotEmpty()){
            _state.value=_state.value.copy(
                isUsernameError = false,
                usernameError = ""
            )
        }


    }

    fun onPasswordChange(newValue: String){
        _state.value=_state.value.copy(
            password = newValue

        )
        if (_state.value.password.isNotEmpty()){
            _state.value=_state.value.copy(
                isPasswordError = false,
                passwordError = ""
            )

        }
    }

    fun signIn(){
        if (_state.value.username.isBlank()){
            _state.value=_state.value.copy(
                isUsernameError = true,
                usernameError = "Username cannot be empty"
            )
        }

        if (_state.value.password.isBlank()){
            _state.value=_state.value.copy(
                isPasswordError = true,
                passwordError = "Password cannot be empty"
            )
        }

    }

}