package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import com.duoc.appandroidstudioproject.navigation.NavigationEvent
import com.duoc.appandroidstudioproject.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class NavigationFlowViewModel:ViewModel() {

    private val _personalNavigationEvents = MutableSharedFlow<NavigationEvent>()
    val personalNavigationEvents:SharedFlow<NavigationEvent> = _personalNavigationEvents.asSharedFlow()

    fun navigatePageTo(screen: Screen) {
        CoroutineScope(context= Dispatchers.Main).launch{
            _personalNavigationEvents.emit( value= NavigationEvent.NavigateTo(route= screen) )
        }
    }

    fun navigatePageBack() {
        CoroutineScope(context= Dispatchers.Main).launch{
            _personalNavigationEvents.emit(value= NavigationEvent.PopBackStack)
        }
    }

    fun navigatePageUp() {
        CoroutineScope(context= Dispatchers.Main).launch{
            _personalNavigationEvents.emit(value= NavigationEvent.NavigateUp)
        }
    }
}