package org.example.project.UI.screens

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.example.project.domain.classes.Jefe
import org.example.project.UI.viewmodels.JefesScreenViewModel
import org.example.project.UI.composables.ScreenHeader
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun JefesScreen( navController: NavHostController) {
    val viewModel: JefesScreenViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        ScreenHeader(title = "Jefes", onBackClick = { navController.popBackStack() })

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
                    items(state.jefes) { jefe ->
                        JefeItem(jefe)
                    }
                }
            }
        }
    }
}

@Composable
fun JefeItem(jefe: Jefe) {
    var reloadKey by remember { mutableStateOf(0) } // Para forzar recarga

    Row(modifier = Modifier.padding(8.dp)) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            KamelImage(
                resource = asyncPainterResource(jefe.image ?: "https://via.placeholder.com/150", key = reloadKey),
                contentDescription = jefe.name.ifEmpty { "Jefe desconocido" },
                onLoading = { CircularProgressIndicator(modifier = Modifier.size(24.dp)) },
                onFailure = {
                    Text(
                        "🔄 Reintentar",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.clickable {
                            reloadKey++ // Cambia la key y fuerza recarga
                        }
                    )
                }
            )
        }

        Spacer(Modifier.width(8.dp))
        Column {
            Text(jefe.name.ifEmpty { "Sin nombre" }, fontWeight = FontWeight.Bold)
            Text(jefe.description ?: "Sin descripción")
        }
    }
}



