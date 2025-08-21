package com.example.mvvmnavigation.home

import android.os.CountDownTimer
import androidx.navigation.NavController
import com.example.mvvmnavigation.common.ButtonState


data class HomeScreenViewBinding(
    val title: String,
    val buttonState: ButtonState,
    val countDownTimer: String
)

