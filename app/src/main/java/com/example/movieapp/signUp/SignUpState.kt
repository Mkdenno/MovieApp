package com.example.movieapp.signUp

data class SignUpState (
    val username: String="",
    val usernameError: String="",
    val isUsernameError: Boolean=false,

    val email: String="",
    val emailError: String="",
    val isEmailError: Boolean=false,

    val password : String="",
    val passwordError: String="",
    val isPasswordError: Boolean=false
)