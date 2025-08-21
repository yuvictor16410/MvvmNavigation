package com.example.mvvmnavigation

sealed interface NavigationEvent{
    data class MoveEvent(
        val tag: Destination
    ):NavigationEvent

    object MoveBack: NavigationEvent
}