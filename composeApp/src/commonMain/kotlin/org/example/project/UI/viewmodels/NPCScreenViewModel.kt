package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.NPC
import org.example.project.network.EldenRingClient

data class NPCScreenState(
    val isLoading: Boolean = false,
    val npcList: List<NPC> = emptyList(),
    val error: String? = null
)

class NPCScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(NPCScreenState(isLoading = true))
    val state: StateFlow<NPCScreenState> = _state.asStateFlow()

    init {
        loadNPCs()
    }

    private fun loadNPCs() {
        viewModelScope.launch {
            _state.value = NPCScreenState(isLoading = true)
            try {
                val lista = EldenRingClient.getNPCs()
                println("DEBUG: lista NPCs = $lista")
                _state.value = NPCScreenState(
                    isLoading = false,
                    npcList = lista
                )
            } catch (e: Exception) {
                println("DEBUG: error API NPCs = ${e.message}")
                _state.value = NPCScreenState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}



