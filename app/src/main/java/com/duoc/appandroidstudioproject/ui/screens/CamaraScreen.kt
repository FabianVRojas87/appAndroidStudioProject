package com.duoc.appandroidstudioproject.ui.screens

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duoc.appandroidstudioproject.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton

@Composable
fun CamaraScreen(
    innerPadding: PaddingValues,
    // Parámetros opcionales para no romper la llamada desde StartScreen
    onGuardarRegistro: (Bitmap, String, String, String) -> Unit = { _, _, _, _ -> }
) {
    // 1. Memoria para la foto
    var fotoBitmap by remember { mutableStateOf<Bitmap?>(null) }

    // Estados para editar los datos del Registro de Rack
    var mostrarDialogoRegistro by remember { mutableStateOf(false) }
    var codigoRack by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }

    // 2. Lanzador de la cámara (igual al tuyo)
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        fotoBitmap = bitmap
    }

    // 3. Lanzador de permisos (igual al tuyo)
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            cameraLauncher.launch(input = null)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(innerPadding)
    ) {
        if (fotoBitmap != null) {
            // Muestra la foto capturada
            Image(
                bitmap = fotoBitmap!!.asImageBitmap(),
                contentDescription = "Foto del Rack",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )

            // Botones inferiores para Repetir o Ir a Registro
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.7f))
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = { fotoBitmap = null }, // Borra la foto para tomar otra
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text("Repetir Foto")
                }

                Button(
                    onClick = { mostrarDialogoRegistro = true }, // Abre el editor de Rack
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                    Text("Registrar Rack", color = Color.White)
                }
            }
        } else {
            Text(
                text = "Presiona el botón para capturar el Rack",
                color = Color.LightGray,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )

            // Botón original de cámara (solo se muestra cuando aún no hay foto)
            IconButton(
                onClick = { permissionLauncher.launch(android.Manifest.permission.CAMERA) },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .size(80.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_add_a_photo_24),
                    contentDescription = "Tomar Foto",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        // 4. Ventana emergente para editar los datos del Rack antes de enviar
        if (mostrarDialogoRegistro && fotoBitmap != null) {
            AlertDialog(
                onDismissRequest = { mostrarDialogoRegistro = false },
                title = { Text("Nuevo Registro de Rack") },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedTextField(
                            value = codigoRack,
                            onValueChange = { codigoRack = it },
                            label = { Text("Código / Nombre del Rack") },
                            placeholder = { Text("Ej: RACK-01") },
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = ubicacion,
                            onValueChange = { ubicacion = it },
                            label = { Text("Sala / Ubicación") },
                            placeholder = { Text("Ej: Sala Servidores Piso 2") },
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = observaciones,
                            onValueChange = { observaciones = it },
                            label = { Text("Observaciones (Editable)") },
                            placeholder = { Text("Estado de cableado, puertos...") }
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            onGuardarRegistro(fotoBitmap!!, codigoRack, ubicacion, observaciones)
                            mostrarDialogoRegistro = false
                        },
                        enabled = codigoRack.isNotBlank()
                    ) {
                        Text("Guardar y ver registros")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { mostrarDialogoRegistro = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}