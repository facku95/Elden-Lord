package org.example.project.UI.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import elden_lord.composeapp.generated.resources.Res
import elden_lord.composeapp.generated.resources.magias
import org.example.project.UI.eldenColor
import org.example.project.UI.fondoCard
import org.example.project.UI.mantequita
import org.example.project.data.getImagenesHome
import org.example.project.domain.classes.homeImages
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MenuGrid(navController: NavController){
    val data = getImagenesHome()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 10.dp)
    ){

      items(data){
          it->MenuGridCard(it,
          onBotonClick={navController.navigate(it.name)})}
        // la lambda de arriba utiliza el atribuno name de cada elemento
        // del card para usarlo como ruta para que el navhost pueda navegar
        // las rutas están almacedanas como un data class getImagenesHome
    }
}

@Composable
fun MenuGridCard(cards: homeImages,onBotonClick: () -> Unit){
    //Capitaliza el string del nombre de la card porque se reutiliza para marcar
    //la ruta de las vistas al hacer click
    val capitalize = cards.name.replaceFirstChar {
        it.uppercase()
    }

    OutlinedCard(modifier = Modifier.padding(10.dp).clickable(onClick = onBotonClick)) {
        Column(modifier = Modifier.background(color = mantequita),
            horizontalAlignment = Alignment.CenterHorizontally) {
            //imagen
            Image(modifier = Modifier.background(color = fondoCard)
                .fillMaxWidth()
                .size(100.dp)
                ,
                painter = painterResource(cards.resource),
                contentDescription = null
            )
            //texto
            Text(text = capitalize,
                fontSize = 20.sp,
                modifier = Modifier
                    .background(color = mantequita)
                    .padding(4.dp))

        }

    }



}