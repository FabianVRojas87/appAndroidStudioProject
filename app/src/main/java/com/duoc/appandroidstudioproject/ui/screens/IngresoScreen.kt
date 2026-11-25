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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.viewmodel.RackViewModel
import com.duoc.appandroidstudioproject.viewmodel.RegistroRackViewModel

@Composable
fun IngresoScreen(
    innerPadding: PaddingValues,
    execRegistroRackViewModel: RegistroRackViewModel,
    viewModel: RackViewModel = viewModel()
) {
    val registrosRacks by execRegistroRackViewModel.registrosRacks.collectAsState();
    val descripcionOld by execRegistroRackViewModel.descripcion.collectAsState();
    val esAprobadoOld by execRegistroRackViewModel.esAprobado.collectAsState();

    val descripcion by viewModel.descripcion.collectAsState();
    val es_aprobado by viewModel.es_aprobado.collectAsState();
    val direccion by viewModel.direccion.collectAsState();
    val modelo by viewModel.modelo.collectAsState();

    Column(
        modifier= Modifier.padding(innerPadding).fillMaxSize(),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center
    ) {
        Text("Página Ingreso")

        OutlinedTextField(
            value = descripcion,
            onValueChange = { viewModel.descripcion.value = it },
            label = { Text("Descripcion") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = es_aprobado,
                onCheckedChange = { viewModel.es_aprobado.value = it }
            )
            Spacer(Modifier.width(8.dp))
            Text("Aprobado")
        }

        OutlinedTextField(
            value = direccion,
            onValueChange = { viewModel.direccion.value = it },
            label = { Text("Direccion") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = modelo,
            onValueChange = { viewModel.modelo.value = it },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.agregarNuevoRack( descripcion, es_aprobado, direccion, modelo, 1 )
                viewModel.descripcion.value = ""
                viewModel.es_aprobado.value = false
                viewModel.direccion.value = ""
                viewModel.modelo.value = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
    }
}