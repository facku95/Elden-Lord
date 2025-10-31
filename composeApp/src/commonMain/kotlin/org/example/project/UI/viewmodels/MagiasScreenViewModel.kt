package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.Magia
import org.example.project.network.EldenRingClient

data class MagiasScreenState(
    val isLoading: Boolean = false,
    val magias: List<Magia> = emptyList(),
    val error: String? = null
)

class MagiasScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(MagiasScreenState(isLoading = true))
    val state: StateFlow<MagiasScreenState> = _state.asStateFlow()

    init {
        loadMagias()
    }

    private fun loadMagias() {
        viewModelScope.launch {
            _state.value = MagiasScreenState(isLoading = true)
            try {
                // Trae hechizos y conjuros
                val spells = EldenRingClient.getSpells()
                val incantations = EldenRingClient.getIncantations()
                val allMagias = spells + incantations

                println("DEBUG: lista magias = $allMagias")
                _state.value = MagiasScreenState(
                    isLoading = false,
                    magias = allMagias
                )
            } catch (e: Exception) {
                println("DEBUG: error API magias = ${e.message}")
                _state.value = MagiasScreenState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}
