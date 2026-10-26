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
import com.duoc.appandroidstudioproject.ui.theme.AppAndroidStudioProjectTheme
import com.duoc.appandroidstudioproject.ui.theme.Login

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAndroidStudioProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

fun setContent(function: Any) {
    TODO("Not yet implemented")
}

annotation class BasicoTheme(val value: @Composable () -> Unit)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        BasicoTheme{ // <- aquí va el nombre de TU TEMA, lo puedes encontrar en ui/theme/Theme.kt
            //GoogleMaps()
            //Canciones(viewModelCanciones)
            //Formulario(viewModelForm)
            //BotonCargando()
            //TextoInvertido()
            //Persistencia()
            //UsuarioFormScreen()
            //Modal()
            // Formulario()
            Login()
            //Navegacion()
            //CamaraFotos()
            //ModalScreen()
            // GPS()
            //AgregarUsuarios()
            // TocarPantalla()
        }
    }
