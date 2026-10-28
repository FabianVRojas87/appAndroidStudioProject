package com.duoc.appandroidstudioproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.duoc.appandroidstudioproject.ui.layouts.EspacioNavegacion
import com.duoc.appandroidstudioproject.ui.theme.AppAndroidStudioProjectTheme
import com.duoc.appandroidstudioproject.ui.theme.Login

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAndroidStudioProjectTheme {
                EspacioNavegacion()
            }
        }
    }
}