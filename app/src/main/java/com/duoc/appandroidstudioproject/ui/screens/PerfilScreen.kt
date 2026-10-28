package com.duoc.appandroidstudioproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.duoc.appandroidstudioproject.R
import com.duoc.appandroidstudioproject.navigation.Screen
import com.duoc.appandroidstudioproject.viewmodel.NavigationFlowViewModel

@Composable
fun PerfilScreen(
    innerPadding: PaddingValues,
    navigationFlowViewModel: NavigationFlowViewModel = viewModel()
) {
    Column(
        modifier= Modifier.padding(innerPadding).fillMaxSize(),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center
    ) {
        Text("Página Perfil")
        Button(
            onClick = { navigationFlowViewModel.navigatePageTo(Screen.PerfilEditar) }
        ) {
            Icon( painter = painterResource(R.drawable.outline_border_color_24), contentDescription = "Editar")
        }
        Button(
            onClick = { navigationFlowViewModel.navigatePageTo(Screen.Login) }
        ) {
            Icon( painter = painterResource(R.drawable.outline_exit_to_app_24), contentDescription = "Editar")
        }
    }
}