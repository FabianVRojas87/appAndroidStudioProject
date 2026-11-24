package com.duoc.appandroidstudioproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.appandroidstudioproject.model.RegistroRack
import com.duoc.appandroidstudioproject.model.Usuario
import com.duoc.appandroidstudioproject.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UsuarioViewModel(): ViewModel() {}