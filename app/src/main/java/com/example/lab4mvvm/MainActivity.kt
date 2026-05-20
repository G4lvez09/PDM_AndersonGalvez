package com.example.lab4mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab4mvvm.views.AppNavigation
import com.example.lab4mvvm.ui.theme.Lab4mvvmTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            Lab4mvvmTheme {

                AppNavigation()
            }
        }
    }
}