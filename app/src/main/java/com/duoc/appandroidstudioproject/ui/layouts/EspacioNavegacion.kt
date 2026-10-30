package com.duoc.appandroidstudioproject.ui.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duoc.appandroidstudioproject.navigation.NavigationEvent
import com.duoc.appandroidstudioproject.navigation.Screen
import com.duoc.appandroidstudioproject.ui.screens.LoginScreen
import com.duoc.appandroidstudioproject.ui.screens.SplashScreen
import com.duoc.appandroidstudioproject.ui.screens.StartScreen
import com.duoc.appandroidstudioproject.viewmodel.NavigationFlowViewModel
import com.duoc.appandroidstudioproject.viewmodel.RegistroRackViewModel
import com.duoc.appandroidstudioproject.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EspacioNavegacion(
    tranRegistroRackViewModel:RegistroRackViewModel
    //tranUsuarioViewModel: UsuarioViewModel
) {
    val originalNavController = rememberNavController()
    val navigationFlowViewModel: NavigationFlowViewModel = viewModel()

    LaunchedEffect(key1= Unit) {
        navigationFlowViewModel.personalNavigationEvents.collectLatest { event ->
            when(event) {
                is NavigationEvent.NavigateTo -> {
                    originalNavController.navigate(route= event.route.route) {
                        event.popUpToRoute?.let{
                            popUpTo(route= it.route) { inclusive= event.inclusive }
                        }
                        launchSingleTop= event.singleTop
                        restoreState= true
                    }
                }
                is NavigationEvent.PopBackStack -> { originalNavController.popBackStack() }
                is NavigationEvent.NavigateUp -> { originalNavController.navigateUp() }
            }
        }
    }

    NavHost(
        navController= originalNavController,
        startDestination= "splash_screen"
    ) {
        composable(route = "splash_screen") {
            SplashScreen(
                onSplashFinished = {
                    // Cuando terminen los 6 segundos, salta a la pantalla Start original
                    originalNavController.navigate(Screen.Login.route) {
                        // Esto borra el Splash de la memoria para que el usuario no pueda volver a él con el botón "Atrás"
                        popUpTo("splash_screen") { inclusive = true }
                    }
                }
            )
        }
        composable(route= Screen.Login.route) {
            LoginScreen(personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel)
        }
        composable(route= Screen.Start.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.Start.route
            )
        }
        composable(route= Screen.Ingreso.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.Ingreso.route
            )
        }
        composable(route= Screen.Camara.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.Camara.route
            )
        }
        composable(route= Screen.Registros.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.Registros.route
            )
        }
        composable(route= Screen.RegistrosHistorial.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.RegistrosHistorial.route
            )
        }
        composable(route= Screen.RegistrosEditar.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.RegistrosEditar.route
            )
        }
        composable(route= Screen.Perfil.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.Perfil.route
            )
        }
        composable(route= Screen.PerfilEditar.route) {
            EspacioScaffold(
                personalNavController=originalNavController, navigationFlowViewModel=navigationFlowViewModel,
                tranRegistroRackViewModel=tranRegistroRackViewModel,
                //tranUsuarioViewModel=tranUsuarioViewModel,
                screenObjetivo=Screen.PerfilEditar.route
            )
        }
    }
}