package org.example.project.domain.classes

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val id: String = "",
    val name: String = "",
    val image: String? = null,
    val description: String? = null,
    val category: String? = null,
    val effects: String? = null,
    val weight: Double? = null
)
@Serializable
data class ListaItems(
    val data: List<Item>
)