package org.example.project.UI.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import elden_lord.composeapp.generated.resources.Elden_lord_logo
import elden_lord.composeapp.generated.resources.Res
import org.example.project.UI.composables.MenuGrid
import org.example.project.UI.eldenColor
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .background(color = eldenColor)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painterResource(Res.drawable.Elden_lord_logo),
                null,
                modifier = Modifier.size(170.dp)
            )

        }

        MenuGrid(navController)

    }
}