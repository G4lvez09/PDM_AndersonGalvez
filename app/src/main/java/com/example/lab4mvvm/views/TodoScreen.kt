package com.example.lab4mvvm.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab4mvvm.components.CreateTask
import com.example.lab4mvvm.components.TaskCard
import com.example.lab4mvvm.model.Task
import com.example.lab4mvvm.viewmodel.GeneralViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(viewModel: GeneralViewModel) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    val tasks = viewModel.tasks.collectAsState()

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Tasks List")
                }
            )
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {

            items(tasks.value) { task ->

                TaskCard(task)

                Spacer(
                    modifier = Modifier.height(24.dp)
                )
            }
        }

        if (showDialog) {

            CreateTask(

                onDismiss = {
                    showDialog = false
                },

                onTaskCreated = { title, description ->

                    val task = Task(
                        id = tasks.value.size + 1,
                        title = title,
                        description = description
                    )

                    viewModel.addTask(task)

                    showDialog = false
                }
            )
        }
    }
}