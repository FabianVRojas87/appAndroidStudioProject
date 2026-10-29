package com.duoc.appandroidstudioproject.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.duoc.appandroidstudioproject.navigation.Screen
import com.duoc.appandroidstudioproject.viewmodel.NavigationFlowViewModel

@Composable
fun LoginScreen(
    navigationFlowViewModel: NavigationFlowViewModel = viewModel()
) {
    Column(
        modifier= Modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center
    ) {
        Text("Página Login")
        Button(
            onClick = { navigationFlowViewModel.navigatePageTo(Screen.Start) }
        ) { Text("Correcto") }
        //Button( onClick = { Toast.makeText(this as Context?, "-Error-", Toast.LENGTH_SHORT).show() } ) { Text("Incorrecto") }
    }
}