package com.example.mvvmnavigation.common

data class ButtonState(
    val onClick: () -> Unit,
    val buttonText: String
)