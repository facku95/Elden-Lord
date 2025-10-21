package org.example.project.UI.screens

import org.example.project.UI.viewmodels.ArmasScreenViewModel




import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.example.project.domain.classes.Arma
//import org.example.project.ui.viewmodels.ArmasScreenViewModel

@Composable
fun ArmasScreen(viewModel: ArmasScreenViewModel) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.Center)
                )
            }

            state.error != null -> {
                Text(
                    text = "Error: ${state.error}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.Center)
                )
            }

            else -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.armas) { arma ->
                        ArmaItem(arma)
                    }
                }
            }
        }
    }
}

@Composable
fun ArmaItem(arma: Arma) {
    Row(modifier = Modifier.padding(8.dp)) {
        KamelImage(
            resource = asyncPainterResource(arma.image ?: "https://via.placeholder.com/150"),
            contentDescription = arma.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            onFailure = {
                Text("Error cargando imagen")
            }
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(arma.name, fontWeight = FontWeight.Bold)
            Text(arma.description ?: "Sin descripción")
        }
    }
}