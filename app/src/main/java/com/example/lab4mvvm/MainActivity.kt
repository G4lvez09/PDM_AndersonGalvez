package com.example.lab4mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab4mvvm.model.TaskDatabase
import com.example.lab4mvvm.ui.theme.Lab4mvvmTheme
import com.example.lab4mvvm.viewmodel.GeneralViewModel
import com.example.lab4mvvm.views.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val database = TaskDatabase.getDatabase(this)
        val taskDao = database.taskDao()

        setContent {
            Lab4mvvmTheme {

                val viewModel: GeneralViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        @Suppress("UNCHECKED_CAST")
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return GeneralViewModel(taskDao) as T
                        }
                    }
                )


                AppNavigation(viewModel)
            }
        }
    }
}