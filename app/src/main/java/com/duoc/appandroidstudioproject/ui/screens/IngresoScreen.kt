package com.duoc.appandroidstudioproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.viewmodel.RegistroRackViewModel

@Composable
fun IngresoScreen(
    innerPadding: PaddingValues,
    execRegistroRackViewModel: RegistroRackViewModel
) {
    val registrosRacks by execRegistroRackViewModel.registrosRacks.collectAsState();
    val descripcion by execRegistroRackViewModel.descripcion.collectAsState();
    val esAprobado by execRegistroRackViewModel.esAprobado.collectAsState();

    Column(
        modifier= Modifier.padding(innerPadding).fillMaxSize(),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center
    ) {
        Text("Página Ingreso")

        OutlinedTextField(
            value = descripcion,
            onValueChange = { execRegistroRackViewModel.descripcion.value = it },
            label = { Text("Descripcion") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = esAprobado,
                onCheckedChange = { execRegistroRackViewModel.esAprobado.value = it }
            )
            Spacer(Modifier.width(8.dp))
            Text("Aprobado")
        }

        Button(
            onClick = {
                execRegistroRackViewModel.agregarRegistroRack( RegistroRack(descripcion = descripcion, esAprobado = esAprobado) )
                execRegistroRackViewModel.descripcion.value = ""
                execRegistroRackViewModel.esAprobado.value = false
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
    }
}