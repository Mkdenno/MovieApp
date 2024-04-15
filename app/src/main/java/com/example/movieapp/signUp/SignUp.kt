package com.example.movieapp.signUp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.components.Input
import com.example.movieapp.components.InputPassword
import com.example.movieapp.components.PrimaryButton

@Composable
fun SignUpScreen(
    navigateBack:()->Unit,
    navigateToSignIn:()->Unit,
    signUpViewModel: SignUpViewModel
) {

//    var username by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }

    val state by signUpViewModel.state.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = "Create Account", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        Input(label = "Username", value =state.username, isError = state.isUsernameError, errorMessage = state.usernameError , placeholder ="Enter Username" , onValueChange = {
            signUpViewModel.onUsernameChange(it)
        })
        Spacer(modifier = Modifier.height(8.dp))

        Input(label = "Email", isError = state.isEmailError, errorMessage = state.emailError, value =state.email , placeholder ="Enter Email" , onValueChange = {
           signUpViewModel.onEmailChange(it)
        })
        Spacer(modifier = Modifier.height(8.dp))

        InputPassword(value = state.password, isError = state.isPasswordError, errorMessage = state.passwordError , placeholder = "Enter Password", onValueChange ={
            signUpViewModel.onPasswordChange(it)
        } )

        Spacer(modifier = Modifier.height(8.dp))

        PrimaryButton(label = "Register", onClick = {
//            navigateBack()
            signUpViewModel.signUp()

        })
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Already have an Account?",
            modifier = Modifier
                .clickable { navigateToSignIn() }

        )



    }

}