package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.UI.screens.HomeScreen
import org.example.project.UI.screens.ArmasScreen
import org.example.project.UI.screens.CenizasScreen
import org.example.project.UI.screens.JefesScreen
import org.example.project.UI.screens.ItemsScreen
import org.example.project.UI.screens.MagiasScreen
import org.example.project.UI.screens.NPCScreen
import org.example.project.UI.viewmodels.ArmasScreenViewModel
import org.example.project.UI.viewmodels.CenizasScreenViewModel
import org.example.project.UI.viewmodels.ItemsScreenViewModel
import org.example.project.UI.viewmodels.JefesScreenViewModel
import org.example.project.UI.viewmodels.MagiasScreenViewModel
import org.example.project.UI.viewmodels.NPCScreenViewModel

@Composable
fun App() {
    val navControl = rememberNavController()

    NavHost(navController = navControl, startDestination = "home") {

        composable("home") { HomeScreen(navControl) }

        composable("armas") {
            val viewModel = ArmasScreenViewModel()
            ArmasScreen(viewModel, navControl)
        }

        composable("jefes") {
            val viewModel = JefesScreenViewModel()
            JefesScreen(viewModel, navControl)
        }

        composable("items") {
            val viewModel = ItemsScreenViewModel()  // instancia directa, sin Koin
            ItemsScreen(viewModel = viewModel, navController = navControl)
        }

        composable("npc") {
            val viewModel = NPCScreenViewModel()
            NPCScreen(viewModel = viewModel, navController = navControl)
        }

        composable("cenizas") {
            val viewModel = CenizasScreenViewModel()
            CenizasScreen(viewModel = viewModel, navController = navControl)
        }

        composable("magias") {
            val viewModel = MagiasScreenViewModel()
            MagiasScreen(viewModel = viewModel, navController = navControl)
        }
    }
}

