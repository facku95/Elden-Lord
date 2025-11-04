package org.example.project.UI.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.UI.mantequita

@Composable
fun ListaAttackCards(lista: List<String>?){

    if (lista != null) {
        LazyColumn {
            items(lista) { elemento ->
               Card (modifier = Modifier.padding(all=5.dp)){
                   Text(text = elemento, modifier = Modifier.background(color=mantequita).padding(all=5.dp))
               }
            }
        }
    }
}