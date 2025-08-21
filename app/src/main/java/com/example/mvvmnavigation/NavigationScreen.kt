package com.example.mvvmnavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmnavigation.NavigationEvent.MoveBack
import com.example.mvvmnavigation.NavigationEvent.MoveEvent
import com.example.mvvmnavigation.detail.DetailScreen
import com.example.mvvmnavigation.detail.DetailViewModel
import com.example.mvvmnavigation.home.HomeScreen
import com.example.mvvmnavigation.home.HomeViewModel

@Composable
fun NavigationScreen(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.HOME_SCREEN.route
    ){
        composable(Destination.HOME_SCREEN.route){
            val homeViewModel: HomeViewModel = viewModel()
            HomeScreen(homeViewModel.binding)

            LaunchedEffect(Unit){
                homeViewModel.getEvent().collect {
                    when(it){
                        is MoveEvent -> { navController.navigate(it.tag.route) }
                        else -> {}
                    }
                }
            }
        }

        composable(Destination.DETAILS_SCREEN.route){
            val detailViewModel: DetailViewModel = viewModel()

            DetailScreen(detailViewModel.binding)
            LaunchedEffect(Unit) {
                detailViewModel.getEvent().collect {
                    when (it) {
                        is MoveEvent -> navController.popBackStack()
                        is MoveBack -> navController.popBackStack()
                    }
                }
            }
        }
    }
}

