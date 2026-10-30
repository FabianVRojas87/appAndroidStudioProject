package com.duoc.appandroidstudioproject.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duoc.appandroidstudioproject.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    // Esta función avisa cuando pasaron los 6 segundos para cambiar de pantalla
    onSplashFinished: () -> Unit
) {
    // Temporizador exacto de 6 segundos (6000 milisegundos)
    LaunchedEffect(key1 = true) {
        delay(6000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // 1. La foto de los Racks al fondo
        Image(
            painter = painterResource(id = R.drawable.rack_towers),
            contentDescription = "Fondo de Bienvenida",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 2. Capa oscura para asegurar que el texto crema brille y se lea bien
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.6f))
        )

        // 3. Logo y Texto centrados
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icono simulando el Logo (Azul Rey)

            /*
            Icon(
                imageVector = Icons.Default.Storage, // Icono de servidores
                contentDescription = "Logo InfraScanRack",
                modifier = Modifier.size(120.dp),
                tint = Color(0xFF4169E1) // Código hexadecimal exacto para Azul Rey
            )
            */
            Spacer(modifier = Modifier.height(16.dp))

            // Nombre de la aplicación (Beige / Cremita)
            Text(
                text = "InfraScanRack",
                color = Color(0xFFF5F5DC), // Código hexadecimal para Beige/Crema
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}