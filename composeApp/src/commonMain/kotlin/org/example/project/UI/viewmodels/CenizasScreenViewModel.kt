package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.Ceniza
import org.example.project.network.EldenRingClient

data class CenizasScreenState(
    val isLoading: Boolean = false,
    val cenizas: List<Ceniza> = emptyList(),
    val error: String? = null
)

class CenizasScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(CenizasScreenState(isLoading = true))
    val state: StateFlow<CenizasScreenState> = _state.asStateFlow()

    init {
        loadCenizas()
    }

    private fun loadCenizas() {
        viewModelScope.launch {
            _state.value = CenizasScreenState(isLoading = true)
            try {
                val lista = EldenRingClient.getCenizas()
                println("DEBUG: lista cenizas = $lista")
                _state.value = CenizasScreenState(
                    isLoading = false,
                    cenizas = lista
                )
            } catch (e: Exception) {
                println("DEBUG: error API cenizas = ${e.message}")
                _state.value = CenizasScreenState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}
