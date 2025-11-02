package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.example.project.UI.composables.WeaponDetail
import org.example.project.UI.screens.HomeScreen
import org.example.project.UI.screens.ArmasScreen
import org.example.project.UI.screens.CenizasScreen
import org.example.project.UI.screens.JefesScreen
import org.example.project.UI.screens.ItemsScreen
import org.example.project.UI.screens.MagiasScreen
import org.example.project.UI.screens.NPCScreen
import org.example.project.UI.viewmodels.ArmaScreenState
import org.example.project.UI.viewmodels.ArmasScreenViewModel
import org.example.project.UI.viewmodels.CenizasScreenViewModel
import org.example.project.UI.viewmodels.ItemsScreenViewModel
import org.example.project.UI.viewmodels.JefesScreenViewModel
import org.example.project.UI.viewmodels.MagiasScreenViewModel
import org.example.project.UI.viewmodels.NPCScreenViewModel
import org.example.project.UI.viewmodels.appModule
import org.koin.compose.KoinApplication

@Composable
fun App() {
    val navControl = rememberNavController()

    KoinApplication(
        application = {modules(appModule)}
    ){
        NavHost(navController = navControl, startDestination = "home") {

            composable("home") { HomeScreen(navControl) }

            composable("armas") {

                ArmasScreen(navControl)
            }

            composable("jefes") {

                JefesScreen(navControl)
            }

            composable("items") {

                ItemsScreen(navController = navControl)
            }

            composable("npc") {

                NPCScreen(navController = navControl)
            }

            composable("cenizas") {

                CenizasScreen(navController = navControl)
            }

            composable("magias") {

                MagiasScreen(navController = navControl)
            }



            composable(
                route = "armadetail/{armaId}", // 1. Placeholder del argumento
                arguments = listOf(
                    navArgument("armaId") {
                        type = NavType.StringType // 2. Especifica que es un String
                        nullable = true // Opcional, pero seguro
                    }
                )
            ) { backStackEntry ->

                // 3. Extracción del argumento de la ruta
                val armaId = backStackEntry.arguments?.getString("armaId")

                // 4. Llamar al Composable, pasándole el ID extraído
                WeaponDetail(
                    armaid = armaId, // ⬅️ Este ID es el que se inyectará en el ViewModel
                    navController = navControl)
            }


        }
    }





}

