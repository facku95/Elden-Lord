package org.example.project.UI.screens

import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArmasScreen(){
    OutlinedCard {
        Text(text = "ARMAS" , fontSize = 50.sp)
    }
}