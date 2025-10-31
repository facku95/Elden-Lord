package org.example.project.domain.classes

import kotlinx.serialization.Serializable

@Serializable
data class Arma(
    val id: String = "",
    val name: String = "",
    val image: String? = null,
    val description: String? = null,
    val attack: List<Attack>? = null,
    val defence: List<Defence>? = null,
    val scalesWith: List<Scaling>? = null,
    val requiredAttributes: List<RequiredAttribute>? = null,
    val category: String? = null,
    val weight: Double? = null
)
fun printAttack(): List<String>{
    var lista : List<String> = emptyList()
    //var ataque : List<> =




    return lista
}

@Serializable
data class Attack(
    val name: String = "",
    val amount: Int = 0
){
    override fun toString(): String {
        var texto : String = "$name" +": $amount \n"

        return texto
    }

}

@Serializable
data class Defence(
    val name: String = "",
    val amount: Int = 0
)

@Serializable
data class Scaling(
    val name: String = "",
    val scaling: String = ""
)

@Serializable
data class RequiredAttribute(
    val name: String = "",
    val amount: Int = 0
)
