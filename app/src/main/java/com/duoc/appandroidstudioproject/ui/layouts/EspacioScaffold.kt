package com.duoc.appandroidstudioproject.ui.layouts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.duoc.appandroidstudioproject.R
import com.duoc.appandroidstudioproject.navigation.Screen
import com.duoc.appandroidstudioproject.ui.screens.CamaraScreen
import com.duoc.appandroidstudioproject.ui.screens.IngresoScreen
import com.duoc.appandroidstudioproject.ui.screens.PerfilEditarScreen
import com.duoc.appandroidstudioproject.ui.screens.PerfilScreen
import com.duoc.appandroidstudioproject.ui.screens.RegistrosEditarScreen
import com.duoc.appandroidstudioproject.ui.screens.RegistrosHistorialScreen
import com.duoc.appandroidstudioproject.ui.screens.RegistrosScreen
import com.duoc.appandroidstudioproject.ui.screens.StartScreen
import com.duoc.appandroidstudioproject.viewmodel.NavigationFlowViewModel

@Composable
fun EspacioScaffold(
    personalNavController: NavController,
    navigationFlowViewModel: NavigationFlowViewModel = viewModel(),
    screenObjetivo: String
) {
    val itemsNavBar= listOf(Screen.Ingreso, Screen.Camara, Screen.Registros, Screen.Perfil);
    var selectedItem by remember { mutableStateOf(value=1) };

    Scaffold(
        bottomBar= {
            NavigationBar{
                itemsNavBar.forEachIndexed{ index,screen ->
                    NavigationBarItem(
                        selected= selectedItem==index,
                        onClick= {
                            selectedItem= index;
                            navigationFlowViewModel.navigatePageTo(screen);
                        },
                        label= { Text(text= screen.route) },
                        icon= {
                            Icon(
                                painter = when(screen) {
                                    Screen.Ingreso -> painterResource(id = R.drawable.outline_assignment_add_24)
                                    Screen.Camara -> painterResource(id = R.drawable.outline_add_a_photo_24)
                                    Screen.Registros -> painterResource(id = R.drawable.baseline_fact_check_24)
                                    else -> painterResource(id = R.drawable.baseline_person_24)     //Screen.Perfil
                                },
                                contentDescription = screen.route
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        when(screenObjetivo) {
            "start_page" -> StartScreen(innerPadding)
            "ingreso_page" -> IngresoScreen(innerPadding)
            "camara_page" -> CamaraScreen(innerPadding)
            "registros_page" -> RegistrosScreen(innerPadding)
            "registros_historial_page" -> RegistrosHistorialScreen(innerPadding)
            "registros_editar_page" -> RegistrosEditarScreen(innerPadding)
            "perfil_page" -> PerfilScreen(innerPadding)
            "perfil_editar_page" -> PerfilEditarScreen(innerPadding)
            else -> Text("Preview")
        }
    }
}


@Preview(showBackground= true)
@Composable
fun EspacioScaffoldPreview() {
    val personalNavController = rememberNavController();
    val navigationFlowViewModel: NavigationFlowViewModel = viewModel();
    val screenObjetivo:String = "Preview";
    EspacioScaffold(personalNavController, navigationFlowViewModel, screenObjetivo)
}