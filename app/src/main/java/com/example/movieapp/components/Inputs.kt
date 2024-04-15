package com.example.movieapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Input(
    label: String,
    value: String,
    errorMessage:String,
    isError:Boolean,
    placeholder: String,
    onValueChange:(String)->Unit,
    modifier: Modifier = Modifier
) {
    Column (
       modifier =Modifier.fillMaxWidth()
    ){

        Text(text = label)
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange =onValueChange,
            placeholder={
                Text(text = placeholder)
            },
            modifier = Modifier.fillMaxWidth()
        )

        if (isError){
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 15.sp
                )
        }

    }
}

@Composable
fun InputPassword(
    label: String="Password",
    value: String,
    isError:Boolean,
    errorMessage:String,
    placeholder: String="Enter Password",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier=Modifier.fillMaxWidth()
    ) {
        Text(text = label)
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value =value,
            onValueChange =onValueChange,
            placeholder= {
                Text(text = placeholder)
            },
            modifier =Modifier.fillMaxWidth(),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation =if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            trailingIcon = {
                IconButton(onClick = {
                    passwordVisible = !passwordVisible

                }) {
                    Icon(
                        imageVector =if(passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility ,
                        contentDescription = null
                    )

                }
            }



        )

        if (isError){
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 15.sp
            )
        }
    }

    
}