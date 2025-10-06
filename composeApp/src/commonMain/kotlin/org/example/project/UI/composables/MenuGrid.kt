package org.example.project.UI.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import elden_lord.composeapp.generated.resources.Res
import elden_lord.composeapp.generated.resources.magias
import org.example.project.UI.eldenColor
import org.example.project.data.getImagenesHome
import org.example.project.domain.classes.homeImages
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MenuGrid(){
    val data = getImagenesHome()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.background(color = eldenColor).fillMaxWidth().padding(8.dp)
    ){
      items(data){ it->MenuGridCard(it)
      }
    }
}



@Composable
fun MenuGridCard(cards: homeImages){
    val capitalize = cards.name.replaceFirstChar {
        it.uppercase()
    }
    Box(){
    Card() {
        //imagen
        Image(modifier = Modifier.background(color = eldenColor).fillMaxWidth().size(110.dp),
            painter = painterResource(cards.resource),
            contentDescription = null
        )
        //texto
        Column(modifier = Modifier.background(color = eldenColor).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(text = capitalize,
                fontSize = 24.sp,
                modifier = Modifier.background(Color.White))

        }
    }

    }

}