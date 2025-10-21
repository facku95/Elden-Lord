package org.example.project.domain.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AttackDTO(
    val name: String,
    val amount: Int
)

@Serializable
data class WeaponDTO(
    val id: String,
    val name: String? = null,
    val description: String? = null,
    val image: String? = null,
    val attack: AttackDTO? = null
)

@Serializable
data class ListaArmasDTO(
    val success: Boolean,
    val count: Int,
    val data: List<WeaponDTO>
)
