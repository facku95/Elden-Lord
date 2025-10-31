package org.example.project.domain.classes

import kotlinx.serialization.Serializable

@Serializable
data class Magia(
    val id: String = "",
    val name: String = "",
    val image: String? = null,
    val description: String? = null,
    val type: String? = null,  // tipo de magia: hechizo, incantation, etc.
    val cost: Int? = null       // coste de FP o recursos
)
@Serializable
data class ListaMagias(
    val data: List<Magia>
)