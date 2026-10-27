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
import com.duoc.appandroidstudioproject.ui.screens.StartScreen
import com.duoc.appandroidstudioproject.viewmodel.NavigationFlowViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EspacioNavegacion() {
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
        startDestination= Screen.Start.route
    ) {
        composable(route= Screen.Login.route) {
            LoginScreen()
        }
        composable(route= Screen.Start.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.Start.route)
        }
        composable(route= Screen.Ingreso.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.Ingreso.route)
        }
        composable(route= Screen.Camara.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.Camara.route)
        }
        composable(route= Screen.Registros.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.Registros.route)
        }
        composable(route= Screen.RegistrosHistorial.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.RegistrosHistorial.route)
        }
        composable(route= Screen.RegistrosEditar.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.RegistrosEditar.route)
        }
        composable(route= Screen.Perfil.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.Perfil.route)
        }
        composable(route= Screen.PerfilEditar.route) {
            EspacioScaffold(originalNavController, navigationFlowViewModel, Screen.PerfilEditar.route)
        }
    }
}