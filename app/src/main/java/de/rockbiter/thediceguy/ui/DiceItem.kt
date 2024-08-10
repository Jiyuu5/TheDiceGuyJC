package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun DiceItem(imageResource: Int, modifier: Modifier){
    Image(painter = painterResource(id = imageResource), contentDescription = "", modifier)
}