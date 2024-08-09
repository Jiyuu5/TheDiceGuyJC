package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SetUi(set: String){
    Column {
        Text(text = set)
    }
}