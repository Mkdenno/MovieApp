package com.example.movieapp.signIn

data class SignInState(
    val username: String="",
    val usernameError: String="",
    val isUsernameError: Boolean=false,
    val password: String="",
    val passwordError: String="",
    val isPasswordError: Boolean=false
)