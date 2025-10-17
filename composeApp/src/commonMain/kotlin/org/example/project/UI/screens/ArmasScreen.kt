package org.example.project.UI.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import org.example.project.UI.viewmodels.ArmasScreenViewModel
import org.example.project.UI.viewmodels.ArmasViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Preview
@Composable
fun ArmasScreen(){
    val viewModel : ArmasScreenViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    OutlinedCard {
        Text(text = "ARMAS" , fontSize = 50.sp)
    }
    Spacer(modifier = Modifier.size(10.dp))

    LazyColumn {
        val lista = state.armas
        items(lista){
            lista ->
            Card {
                Text(text = lista.nombre.toString())
                Text(text = lista.descripcion.toString())
                Text(text = lista.damage.toString())
            }
        }
    }
}