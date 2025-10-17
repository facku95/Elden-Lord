package org.example.project.domain.repositories

import org.example.project.domain.classes.Arma


fun getArmasRepository() : List<Arma>{
     val localData = listOf(
        Arma("Uchigatana",
            "arma inicial del samurai",
            100),
        Arma("nodachi",
            "la dropea shura",
            120),
        Arma("espadon",
            "espada colosal encontrada en un cofre",
            150),
        Arma("Reduvia",
            "la dropea el invasor cerca de parches",
            90),
        Arma("Colmillo de sabueso",
            "La dropea la carcel eterna del sabueso",
            130)
    )

return localData

}