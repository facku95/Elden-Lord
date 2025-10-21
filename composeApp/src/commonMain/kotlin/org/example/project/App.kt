package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.UI.screens.HomeScreen
import org.example.project.UI.screens.ArmasScreen
import org.example.project.UI.viewmodels.ArmasScreenViewModel
import org.example.project.UI.viewmodels.appModule
//import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.startKoin

@Composable
fun App() {
    val navControl = rememberNavController()

    NavHost(navControl, startDestination = "home") {
        composable("home") {
            HomeScreen(navControl)
        }
        composable("armas") {
            val viewModel = ArmasScreenViewModel()  // Directo, sin Koin
            ArmasScreen(viewModel)
        }
        composable("npc") {}
        composable("cenizas") {}
    }
}
