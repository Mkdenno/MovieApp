package com.example.movieapp.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Box {
        Text(text ="WELCOME HOME", fontWeight = FontWeight.Bold, fontSize = 40.sp )
    }
}

