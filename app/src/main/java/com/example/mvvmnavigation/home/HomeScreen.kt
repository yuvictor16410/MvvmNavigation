package com.example.mvvmnavigation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mvvmnavigation.Destination
import com.example.mvvmnavigation.common.ButtonState

@Composable
fun HomeScreen(binding: HomeScreenViewBinding){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(binding.title)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = binding.buttonState.onClick
        ){
            Text(binding.buttonState.buttonText)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(binding.countDownTimer, fontSize = 45.sp, color = Color.Red)
    }
}

@Composable
@Preview
fun Preview_HomeScreen(){
    HomeScreen(
        binding = HomeScreenViewBinding(
            title = "THIS IS HOME SCREEN",
            buttonState = ButtonState(
                onClick = {

                },
                buttonText = "Go to Details Screen"
            ),
            countDownTimer = "10"
        )
    )
}