package org.example.project.domain.classes

import kotlinx.serialization.Serializable

@Serializable
data class NPC(
    val id: String = "",
    val name: String = "",
    val image: String? = null,
    val quote: String? = "",
    val location: String? = null
)
@Serializable
data class ListaNPC(
    val data: List<NPC>
)