package com.duoc.appandroidstudioproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoBox(text = "Nombre: Admin")
        InfoBox(text = "Correo: admin@gmail.com")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FloatingActionButton(
                onClick = { navigationFlowViewModel.navigatePageTo(Screen.PerfilEditar) }
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_border_color_24),
                    contentDescription = "Editar"
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            FloatingActionButton(
                onClick = { navigationFlowViewModel.navigatePageTo(Screen.Login) }
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_exit_to_app_24),
                    contentDescription = "Salir"
                )
            }
        }
    }
}

@Composable
private fun InfoBox(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 2.dp
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}