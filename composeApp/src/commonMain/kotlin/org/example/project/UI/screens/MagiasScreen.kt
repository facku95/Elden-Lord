package org.example.project.UI.screens

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
import org.example.project.domain.classes.Magia
import org.example.project.UI.composables.ScreenHeader
import org.example.project.UI.viewmodels.MagiasScreenViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MagiasScreen(navController: NavHostController) {
    val viewModel: MagiasScreenViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        ScreenHeader(title = "Magias", onBackClick = { navController.popBackStack() })

        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
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
                    items(state.magias) { magia ->
                        MagiaCard(magia)
                    }
                }
            }
        }
    }
}

@Composable
fun MagiaCard(magia: Magia) {
    Row(modifier = Modifier.padding(8.dp)) {
        KamelImage(
            resource = asyncPainterResource(magia.image ?: "https://via.placeholder.com/150"),
            contentDescription = magia.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            onFailure = { Text("Error cargando imagen") }
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(magia.name, fontWeight = FontWeight.Bold)
            Text(magia.description ?: "Sin descripción")
        }
    }
}
