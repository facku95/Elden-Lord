package org.example.project

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.project.UI.screens.HomeScreen
import androidx.navigation.compose.rememberNavController
import org.example.project.UI.screens.ArmasScreen
import org.example.project.UI.viewmodels.ArmasViewModel
import org.example.project.UI.viewmodels.appModule
import org.koin.core.context.startKoin
import org.koin.compose.viewmodel.koinViewModel

import org.koin.compose.KoinApplication


@Suppress("SuspiciousIndentation")
@Composable

fun App() {

    KoinApplication(
        application = {modules(appModule)}
    ){

        val navControl = rememberNavController()

        NavHost(navControl,startDestination = "home" ){
            composable(route="home"){
                HomeScreen(
                    navControl
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



}