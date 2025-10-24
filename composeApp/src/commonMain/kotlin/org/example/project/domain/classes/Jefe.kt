package org.example.project.domain.classes

import kotlinx.serialization.Serializable

@Serializable
data class Jefe(
    val id: String = "",
    val name: String = "",
    val image: String? = null,
    val description: String? = null
)

@Serializable
data class ListaJefes(
    val data: List<Jefe> = emptyList()
)