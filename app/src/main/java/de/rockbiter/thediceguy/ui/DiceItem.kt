package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun DiceItem(imageResource: Int){
    Image(painter = painterResource(id = imageResource), contentDescription = "")
}