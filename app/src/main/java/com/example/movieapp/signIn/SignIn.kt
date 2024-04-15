package com.example.movieapp.signIn

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
import com.example.movieapp.components.PrimaryButton

@Composable
fun SignInScreen(
    modifier: Modifier =Modifier,
    navigateToSignUp:()->Unit,
    navigateToHomeScreen:()->Unit,
    signInViewModel: SignInViewModel
) {
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }

    val state by signInViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .padding(26.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In", fontWeight = FontWeight.Bold,  fontSize = 28.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Input(label ="Username", value =state.username, isError =state.isUsernameError , errorMessage = state.usernameError , placeholder ="Enter Username" , onValueChange ={
            signInViewModel.onUserNameChange(it)
        } )
        Spacer(modifier = Modifier.height(8.dp))
        Input(label ="Password" , value =state.password, isError = state.isPasswordError, errorMessage = state.passwordError , placeholder ="Enter Password" , onValueChange ={
            signInViewModel.onPasswordChange(it)
        } )
        Spacer(modifier = Modifier.height(8.dp))

        PrimaryButton(label = "Sign In", onClick = {
//            navigateToHomeScreen()
            signInViewModel.signIn()

        })
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Not Registered?", modifier = Modifier
            .clickable { navigateToSignUp() }
        )



    }

}

