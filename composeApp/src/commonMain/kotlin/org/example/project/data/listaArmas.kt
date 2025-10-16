package org.example.project.data

import org.example.project.domain.classes.Arma


fun getArmas(): List<Arma>{
    return listOf(
        Arma("Colmillo de sabueso",
            "Arma que dropea el sabueso",
            "IMAGEN DEL ARMA"
            ),
        Arma("Uchigatana",
            "Arma inicial del samurai",
            "IMAGEN DEL ARMA"
        ),
        Arma("Espadón",
            "Espada colosal que se encuentra en un cofre",
            "IMAGEN DEL ARMA"
        ),
        Arma("Rios de sangre",
            "Arma que dropea shura",
            "IMAGEN DEL ARMA"
        )
    )
}