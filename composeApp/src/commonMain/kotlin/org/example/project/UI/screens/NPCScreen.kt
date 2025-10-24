package org.example.project.UI.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.example.project.UI.composables.ScreenHeader
import org.example.project.UI.viewmodels.NPCScreenViewModel
import org.example.project.domain.classes.NPC

@Composable
fun NPCScreen(viewModel: NPCScreenViewModel, navController: NavHostController) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        ScreenHeader(title = "NPC", onBackClick = { navController.popBackStack() })

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
                    items(state.npcList) { npc ->
                        NPCCard(npc)
                    }
                }
            }
        }
    }
}
@Composable
fun NPCCard(npc: NPC) {
    var reloadKey by remember { mutableStateOf(0) } // Para forzar recarga

    Row(modifier = Modifier.padding(8.dp)) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            KamelImage(
                resource = asyncPainterResource(npc.image ?: "https://via.placeholder.com/150", key = reloadKey),
                contentDescription = npc.name.ifEmpty { "NPC desconocido" },
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
            Text(npc.name.ifEmpty { "Sin nombre" }, fontWeight = FontWeight.Bold)
            Text(npc.description ?: "Sin descripción")
        }
    }
}


