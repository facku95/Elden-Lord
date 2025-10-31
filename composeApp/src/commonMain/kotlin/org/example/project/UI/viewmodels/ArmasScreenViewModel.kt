package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.Arma
import org.example.project.network.EldenRingAPI

data class ArmaScreenState(
    val isLoading: Boolean = false,
    val armas: List<Arma> = emptyList(),
    val error: String? = null
)

class ArmasScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(ArmaScreenState(isLoading = true))
    val state: StateFlow<ArmaScreenState> = _state.asStateFlow()

    private val api = EldenRingAPI()

    init {
        loadArmaData()
    }

    private fun loadArmaData() {
        viewModelScope.launch {
            _state.value = ArmaScreenState(isLoading = true)
            try {
                val lista = api.getWeapons() // ahora es List<Arma>
                println("DEBUG: lista armas = $lista")
                _state.value = ArmaScreenState(
                    isLoading = false,
                    armas = lista
                )
            } catch (e: Exception) {
                println("DEBUG: error API = ${e.message}")
                _state.value = ArmaScreenState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}
