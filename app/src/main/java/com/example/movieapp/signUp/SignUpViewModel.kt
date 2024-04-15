package com.example.movieapp.signUp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel: ViewModel() {
    val _state = MutableStateFlow(SignUpState())
    val state=_state.asStateFlow()

    fun onUsernameChange(newValue: String){
        _state.value=_state.value.copy(
            username = newValue
        )
        if (_state.value.username.isNotEmpty()){
            _state.value=_state.value.copy(
                isUsernameError = false,
                usernameError = ""
            )
        }

    }
    fun onEmailChange(newValue: String){
        _state.value=_state.value.copy(
            email = newValue
        )
        if (_state.value.email.isNotEmpty()){
            _state.value=_state.value.copy(
                isEmailError = false,
                emailError = ""
            )
        }

    }
    fun onPasswordChange(newValue: String){

        _state.value=_state.value.copy(
            password = newValue
        )
        if (state.value.password.isNotEmpty()){
            _state.value=_state.value.copy(
                isPasswordError = false,
                passwordError = ""
            )

        }

    }
    fun signUp(){
        if (_state.value.username.isBlank()){
            _state.value=_state.value.copy(
                isUsernameError = true,
                usernameError = "Username cannot be empty"
            )
        }
        if (_state.value.email.isBlank()){
            _state.value=_state.value.copy(
                isEmailError = true,
                emailError = "Email Cannot be blank"
            )

        }

        if (_state.value.password.isBlank()){
            _state.value=_state.value.copy(
                isPasswordError = true,
                passwordError = "Password Cannot be Empty"
            )

        }

    }

}