package org.example.project.domain.classes

import kotlinx.serialization.Serializable

@Serializable
data class Ceniza(
    val id: String = "",
    val name: String = "",
    val image: String? = null,
    val description: String? = null,
    val category: String? = null
)
@Serializable
data class ListaCenizas(
    val data: List<Ceniza>
)