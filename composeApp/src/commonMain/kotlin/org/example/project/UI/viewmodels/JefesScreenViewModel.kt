package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.Jefe
import org.example.project.network.EldenRingClient

data class JefesState(
    val jefes: List<Jefe> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class JefesScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(JefesState(isLoading = true))
    val state: StateFlow<JefesState> get() = _state

    init {
        fetchJefes()
    }

    private fun fetchJefes() {
        viewModelScope.launch {
            try {
                val result: List<Jefe> = EldenRingClient.getBosses()
                _state.value = JefesState(jefes = result, isLoading = false)
            } catch (e: Exception) {
                _state.value = JefesState(
                    error = e.message ?: "Error desconocido",
                    isLoading = false
                )
            }
        }
    }
}
