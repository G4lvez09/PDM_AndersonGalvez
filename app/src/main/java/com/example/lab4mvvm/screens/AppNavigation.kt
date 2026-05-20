package com.example.lab4mvvm.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab4mvvm.viewmodel.GeneralViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val viewModel: GeneralViewModel = viewModel()

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