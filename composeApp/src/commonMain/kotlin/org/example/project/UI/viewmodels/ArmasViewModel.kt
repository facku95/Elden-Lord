package org.example.project.UI.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.example.project.domain.classes.Arma
import org.example.project.domain.repositories.getArmasRepository

data class ArmasState(
    val armas: List<Arma> = emptyList(), // Lista vacía por defecto
    val isLoading: Boolean = false       // Estado de carga, por ejemplo
)
class ArmasViewModel() {
    private val _uiState = MutableStateFlow(ArmasState()) // -> Inicializa con la lista vacía
    val uiState: StateFlow<ArmasState> = _uiState.asStateFlow()
    init{
        val listaInicial= getArmasRepository()
    }
}