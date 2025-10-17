package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.Arma

import org.example.project.domain.repositories.getArmasRepository

data class ArmaScreenState(
    val isLoading: Boolean =false,
    val armas: List<Arma> = emptyList(),
    val error: String? =null
)

class ArmasScreenViewModel (): ViewModel() {
    private val _state = MutableStateFlow(ArmaScreenState(isLoading = true))
    val state: StateFlow<ArmaScreenState> = _state.asStateFlow()

    init {
        loadArmaData()
    }
    private fun loadArmaData(){
        viewModelScope.launch {

            val loadedArma = getArmasRepository()

            //Actualizar el Estado y notificar a la UI
            _state.value = ArmaScreenState(
                isLoading = false,
                armas = loadedArma
            )
        }
    }

}