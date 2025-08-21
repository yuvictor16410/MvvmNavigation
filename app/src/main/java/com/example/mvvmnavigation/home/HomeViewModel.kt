package com.example.mvvmnavigation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmnavigation.Destination
import com.example.mvvmnavigation.NavigationEvent
import com.example.mvvmnavigation.NavigationEvent.MoveEvent
import com.example.mvvmnavigation.common.ButtonState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel() {

    private val _event = MutableSharedFlow<NavigationEvent>()
    fun getEvent() = _event.asSharedFlow()

    private var _binding by mutableStateOf(
        HomeScreenViewBinding(
            title = "THIS IS HOME SCREEN",
            buttonState = ButtonState(
                onClick = ::moveToNextScreen,
                buttonText = "Go to Details Screen"
            ),
            countDownTimer = "10"
        )
    )

    val binding get() = _binding

    init {
        countDown()
    }

    private fun countDown() {
        viewModelScope.launch {
            for (i in 10 downTo 0) {
                _binding = _binding.copy(
                    countDownTimer = "$i"
                )
                delay(1000)
            }

        }
    }

    private fun moveToNextScreen() {
        println("Hello")
        viewModelScope.launch {
            delay(timeMillis = 1000)
            _event.emit(MoveEvent(tag = Destination.DETAILS_SCREEN))
        }
        println("Goodbye")
    }
}