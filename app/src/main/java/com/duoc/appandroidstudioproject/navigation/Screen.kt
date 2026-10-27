package com.duoc.appandroidstudioproject.navigation

sealed class Screen(val route:String) {
    data object Login:Screen(route= "login_page")
    data object Start:Screen(route= "start_page")
    data object Ingreso:Screen(route= "ingreso_page")
    data object Camara:Screen(route= "camara_page")
    data object Registros:Screen(route= "registros_page")
    data object RegistrosHistorial:Screen(route= "registros_historial_page")
    data object RegistrosEditar:Screen(route= "registros_editar_page")
    data object Perfil:Screen(route= "perfil_page")
    data object PerfilEditar:Screen(route= "perfil_editar_page")
}