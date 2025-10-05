package org.example.project.data

import elden_lord.composeapp.generated.resources.Jefes
import elden_lord.composeapp.generated.resources.NPC
import elden_lord.composeapp.generated.resources.Res
import elden_lord.composeapp.generated.resources.armas
import elden_lord.composeapp.generated.resources.cenizas
import elden_lord.composeapp.generated.resources.items
import elden_lord.composeapp.generated.resources.magias
import org.example.project.domain.classes.homeImages

fun getImagenesHome(): List<homeImages>{
        return listOf(
            homeImages(Res.drawable.armas,"armas"),
            homeImages(Res.drawable.Jefes,"jefes"),
            homeImages(Res.drawable.items,"items"),
            homeImages(Res.drawable.NPC,"npc"),
            homeImages(Res.drawable.cenizas,"cenizas"),
            homeImages(Res.drawable.magias,"magias")
        )
}