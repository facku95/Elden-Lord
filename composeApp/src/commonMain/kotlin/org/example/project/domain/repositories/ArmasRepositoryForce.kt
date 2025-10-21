package org.example.project.domain.repositories

import org.example.project.domain.classes.Arma


fun getArmasRepository() : List<Arma>{
    val localData = listOf(
        Arma("Uchigatana",
            "arma inicial del samurai",
            null),
        Arma("nodachi",
            "la dropea shura",
            null),
        Arma("espadon",
            "espada colosal encontrada en un cofre",
            null),
        Arma("Reduvia",
            "la dropea el invasor cerca de parches",
            null),
        Arma("Colmillo de sabueso",
            "La dropea la carcel eterna del sabueso",
            null)
    )

    return localData

}