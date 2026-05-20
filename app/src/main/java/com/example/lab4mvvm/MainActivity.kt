package com.example.lab4mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab4mvvm.screens.TodoScreen
import com.example.lab4mvvm.ui.theme.Lab4mvvmTheme
import com.example.lab4mvvm.viewmodel.GeneralViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            Lab4mvvmTheme {

                val viewModel: GeneralViewModel = viewModel()

                TodoScreen(viewModel = viewModel)
            }
        }
    }
}


