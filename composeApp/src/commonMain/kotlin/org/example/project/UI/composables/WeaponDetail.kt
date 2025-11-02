package org.example.project.UI.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.parametersOf
import org.example.project.UI.viewmodels.WeaponDetailViewModel
import org.example.project.domain.classes.Arma
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
fun WeaponDetail(armaid: String?,navController: NavController){
    val viewModel: WeaponDetailViewModel = koinViewModel(
        parameters = { parametersOf(armaid?:"") }
    )
    val state by viewModel.state.collectAsState()
    var arma = state.arma

Column {

    Row(modifier = Modifier.padding(top = 30.dp)){

        Box(modifier = Modifier.size(100.dp)){
            KamelImage(
         resource = asyncPainterResource(arma?.image?:"SIN DATA"),
         ""
            )
        }


        Column {
            Text(text = arma?.name.toString() )
            Text(text = arma?.category.toString())
            Text(text = arma?.description.toString())
        }



    }

    Text(text=arma?.attack.toString())
}






}