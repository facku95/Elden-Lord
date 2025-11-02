package org.example.project.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.domain.classes.Arma
import org.example.project.network.EldenRingAPI

data class WeaponDetailScreenState(
    val isLoading: Boolean = false,
    val arma: Arma? = null,
    val error: String? = null
)

class WeaponDetailViewModel(
    private val armaid: String,
    private val api: EldenRingAPI
) : ViewModel(){
    private val _state = MutableStateFlow(WeaponDetailScreenState(isLoading = true))
    val state: StateFlow<WeaponDetailScreenState> = _state.asStateFlow()
    init {
        loadWeaponDetails()
    }

    private fun loadWeaponDetails(){
        viewModelScope.launch {
            try{
                _state.value = _state.value.copy(isLoading = true)
                val loadedArma = api.getWeaponById(armaid)

                _state.value = _state.value.copy(
                    isLoading = false,
                    arma = loadedArma
                )

            } catch (e: Exception){
                println("Error en ArmaDetailViewModel (API): ${e.message}")
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = "Error al obtener detalles del arma: ${e.message}"
                )

            }
        }
    }


}