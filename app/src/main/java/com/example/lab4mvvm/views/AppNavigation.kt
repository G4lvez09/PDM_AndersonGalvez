package com.example.lab4mvvm.views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab4mvvm.viewmodel.GeneralViewModel

@Composable
fun AppNavigation(viewModel: GeneralViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable("create") {
            CreateTaskScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}