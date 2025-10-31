package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.Item
import org.example.project.network.EldenRingAPI
import org.example.project.network.EldenRingClient

data class ItemsScreenState(
    val isLoading: Boolean = false,
    val items: List<Item> = emptyList(),
    val error: String? = null
)

class ItemsScreenViewModel : ViewModel() {


    private val _state = MutableStateFlow(ItemsScreenState(isLoading = true))
    val state: StateFlow<ItemsScreenState> = _state.asStateFlow()

    private val api = EldenRingAPI()

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            _state.value = ItemsScreenState(isLoading = true)
            try {
                val lista = EldenRingClient.getItems() // función en tu client
                println("DEBUG: lista items = $lista")
                _state.value = ItemsScreenState(
                    isLoading = false,
                    items = lista
                )
            } catch (e: Exception) {
                println("DEBUG: error API items = ${e.message}")
                _state.value = ItemsScreenState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}


