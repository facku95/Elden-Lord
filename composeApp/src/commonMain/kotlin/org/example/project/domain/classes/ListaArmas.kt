package org.example.project.domain.classes

import kotlinx.serialization.Serializable

@Serializable
data class ListaArmas(
    val data: List<Arma> = emptyList()
)