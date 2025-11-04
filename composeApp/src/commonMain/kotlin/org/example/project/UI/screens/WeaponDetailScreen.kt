package org.example.project.UI.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import org.example.project.UI.composables.ListaAttackCards
import org.example.project.UI.eldenColor
import org.example.project.UI.mantequita
import org.example.project.UI.viewmodels.WeaponDetailViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
fun WeaponDetail(armaid: String?,navController: NavController,){
    val viewModel: WeaponDetailViewModel = koinViewModel(
        parameters = { parametersOf(armaid?:"") }
    )
    val state by viewModel.state.collectAsState()
    var arma = state.arma
    var lista=arma?.printAttack()

Column(modifier = Modifier.fillMaxSize().background(color= eldenColor)) {

    Row(modifier = Modifier.padding(top = 30.dp)){

        Box(modifier = Modifier
            .padding(all = 5.dp)
            .background(color= mantequita)
            .size(200.dp)

        ){
            KamelImage(
         resource = asyncPainterResource(arma?.image?:"SIN DATA"),
         ""
            )
        }


        Column(modifier = Modifier.padding(all = 5.dp).background(color= mantequita)) {
            Text(text = arma?.name.toString() )
            Text(text = arma?.category.toString())
            Text(text = arma?.description.toString())
        }



    }

    ListaAttackCards(lista)

}






}