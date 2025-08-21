package com.example.mvvmnavigation.detail
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

class DetailViewModel(): ViewModel() {

    private val _event = MutableSharedFlow<NavigationEvent>()
    fun getEvent() = _event.asSharedFlow()

    val binding = DetailScreenViewBinding(
        title = "THIS IS DETAIL SCREEN",
        buttonState = ButtonState(
            onClick = ::moveBackScreen,
            buttonText = "Go to Home Screen"
        )
    )

    private fun moveBackScreen(){
        viewModelScope.launch{
            delay(timeMillis = 1000)
            _event.emit(NavigationEvent.MoveBack)
        }
    }
}