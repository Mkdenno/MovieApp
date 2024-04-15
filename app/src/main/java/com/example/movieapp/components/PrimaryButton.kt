package com.example.movieapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    label:String,
    onClick:()->Unit,
    modifier: Modifier =Modifier
) {
    Button(

        onClick = onClick,
        modifier =Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)

    ) {
        Text(text = label)
        
    }
    
}