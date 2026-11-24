package com.duoc.appandroidstudioproject.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import com.duoc.appandroidstudioproject.R
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duoc.appandroidstudioproject.viewmodel.RegistroFotoRack
import com.duoc.appandroidstudioproject.viewmodel.RegistroRackViewModel

@Composable
fun RegistrosScreen(
    innerPadding: PaddingValues = PaddingValues(),
    viewModel: RegistroRackViewModel
) {
    val registrosPorDia = viewModel.historialFotos.groupBy { it.fechaHora.substringBefore(" ") }

    var itemAEditar by remember { mutableStateOf<RegistroFotoRack?>(null) }
    var editCodigo by remember { mutableStateOf("") }
    var editUbicacion by remember { mutableStateOf("") }
    var editObs by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8))
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text(
            text = "Registros de Racks (${viewModel.historialFotos.size})",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E293B),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        if (registrosPorDia.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Aún no hay fotos de racks registradas.",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                registrosPorDia.forEach { (dia, listaDelDia) ->
                    item {
                        Text(
                            text = "📅 Día: $dia",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2563EB),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    items(listaDelDia, key = { it.id }) { rack ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "🕒 ${rack.fechaHora.substringAfter(" ")}",
                                        fontSize = 13.sp,
                                        color = Color(0xFF64748B)
                                    )
                                    IconButton(
                                        onClick = {
                                            itemAEditar = rack
                                            editCodigo = rack.codigo
                                            editUbicacion = rack.ubicacion
                                            editObs = rack.observaciones
                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.outline_border_color_24),
                                            contentDescription = "Editar",
                                            tint = Color(0xFF2563EB)
                                        )
                                    }
                                }

                                Image(
                                    bitmap = rack.foto.asImageBitmap(),
                                    contentDescription = "Foto ${rack.codigo}",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(180.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Rack: ${rack.codigo}",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1E293B)
                                )
                                if (rack.ubicacion.isNotBlank()) {
                                    Text(
                                        text = "Ubicación: ${rack.ubicacion}",
                                        fontSize = 14.sp,
                                        color = Color(0xFF475569)
                                    )
                                }
                                if (rack.observaciones.isNotBlank()) {
                                    Text(
                                        text = "Observaciones: ${rack.observaciones}",
                                        fontSize = 14.sp,
                                        color = Color(0xFF334155),
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    if (itemAEditar != null) {
        AlertDialog(
            onDismissRequest = { itemAEditar = null },
            title = { Text("Editar Registro de Rack") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = editCodigo,
                        onValueChange = { editCodigo = it },
                        label = { Text("Código del Rack") },
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = editUbicacion,
                        onValueChange = { editUbicacion = it },
                        label = { Text("Sala / Ubicación") },
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = editObs,
                        onValueChange = { editObs = it },
                        label = { Text("Observaciones") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.editarFotoRack(
                            id = itemAEditar!!.id,
                            nuevoCodigo = editCodigo,
                            nuevaUbicacion = editUbicacion,
                            nuevasObs = editObs
                        )
                        itemAEditar = null
                    },
                    enabled = editCodigo.isNotBlank()
                ) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { itemAEditar = null }) {
                    Text("Cancelar")
                }
            }
        )
    }
}