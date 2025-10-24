package org.example.project.UI.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.example.project.UI.composables.ScreenHeader
import org.example.project.UI.viewmodels.CenizasScreenViewModel
import org.example.project.domain.classes.Ceniza

@Composable
fun CenizasScreen(viewModel: CenizasScreenViewModel, navController: NavHostController) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        ScreenHeader(title = "Cenizas", onBackClick = { navController.popBackStack() })

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
                    items(state.cenizas) { ceniza ->
                        CenizaCard(ceniza)
                    }
                }
            }
        }
    }
}
@Composable
fun CenizaCard(ceniza: Ceniza) {
    Row(modifier = Modifier.padding(8.dp)) {
        KamelImage(
            resource = asyncPainterResource(ceniza.image ?: "https://via.placeholder.com/150"),
            contentDescription = ceniza.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            onFailure = { Text("Error cargando imagen") }
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(ceniza.name, fontWeight = FontWeight.Bold)
            Text(ceniza.description ?: "Sin descripción")
        }
    }
}
