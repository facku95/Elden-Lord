package org.example.project.UI.screens

import androidx.compose.foundation.clickable
import org.example.project.UI.viewmodels.ArmasScreenViewModel




import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.example.project.domain.classes.Arma
//import org.example.project.ui.viewmodels.ArmasScreenViewModel
import org.example.project.UI.composables.ScreenHeader
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ArmasScreen(navController: NavHostController) {
    val viewModel : ArmasScreenViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        ScreenHeader(title = "Armas", onBackClick = { navController.popBackStack() })

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            when {
                state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                state.error != null -> Text(
                    text = state.error!!,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
                else -> LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.armas) { arma ->
                        ArmaItem(arma,navController)
                    }
                }
            }
        }
    }
}

@Composable
fun ArmaItem(arma: Arma, navController: NavController) {
    var reloadKey by remember { mutableStateOf(0) } // Para forzar recarga
    val route = "armadetail/${arma.id}"


    Card(onClick = { navController.navigate(route) }) {

        Row(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                KamelImage(
                    resource = asyncPainterResource(arma.image ?: "https://via.placeholder.com/150", key = reloadKey),
                    contentDescription = arma.name.ifEmpty { "Arma desconocida" },
                    onLoading = { CircularProgressIndicator(modifier = Modifier.size(24.dp)) },
                    onFailure = {
                        Text(
                            "🔄 Reintentar",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.clickable { reloadKey++ } // recarga al tocar
                        )
                    }
                )
            }

            Spacer(Modifier.width(8.dp))

            Column {
                Text(arma.name.ifEmpty { "Sin nombre" }, fontWeight = FontWeight.Bold)
                Text(arma.description ?: "Sin descripción")
            }
        }


    }





}
