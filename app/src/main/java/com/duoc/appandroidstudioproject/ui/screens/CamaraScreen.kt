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

@Composable
fun CamaraScreen(
    innerPadding: PaddingValues
) {
    // 1. Memoria para la foto
    var fotoBitmap by remember { mutableStateOf<Bitmap?>(null) }

    // 2. Lanzador de la cámara
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        fotoBitmap = bitmap
    }

    // 3. NUEVO: Lanzador para pedir permiso de cámara al usuario
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Si el usuario dice "Permitir", abrimos la cámara
            cameraLauncher.launch(null)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(innerPadding)
    ) {
        if (fotoBitmap != null) {
            Image(
                bitmap = fotoBitmap!!.asImageBitmap(),
                contentDescription = "Foto del Rack",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        } else {
            Text(
                text = "Presiona el botón para capturar el Rack",
                color = Color.LightGray,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        IconButton(
            // 4. CAMBIO: Al hacer clic, ahora pedimos el permiso primero
            onClick = { permissionLauncher.launch(android.Manifest.permission.CAMERA) },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .size(80.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.White
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.outline_add_a_photo_24),
                contentDescription = "Tomar Foto",
                tint = Color.Black,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}