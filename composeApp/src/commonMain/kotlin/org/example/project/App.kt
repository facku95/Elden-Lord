package org.example.project

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.project.UI.screens.HomeScreen
import androidx.navigation.compose.rememberNavController
import org.example.project.UI.screens.ArmasScreen
import org.example.project.UI.viewmodels.ArmasScreenViewModel


@Suppress("SuspiciousIndentation")
@Composable

fun App() {
 val navControl = rememberNavController()
    val botonClick={navControl.navigate("armas")}
    var ArmasviewModel : ArmasScreenViewModel

    NavHost(navControl,startDestination = "home" ){
        composable(route="home"){
            HomeScreen(
                navControl,
                botonClick
            )
        }
        composable(route="armas"){
            ArmasScreen()
        }
        composable(route="npc"){

        }
        composable(route="cenizas"){

        }


    }



}