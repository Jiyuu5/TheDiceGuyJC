package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rockbiter.thediceguy.R
import de.rockbiter.thediceguy.data.diceSets
import de.rockbiter.thediceguy.model.Dice

val dicesOnScreen = diceSets[0].diceArrayList

@Composable
fun SetUi(set: String){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()) {
        Text(text = set, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
            Text(text = "Score", modifier = Modifier
                .fillMaxWidth()
                .weight(1f))
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.more_vert_32), contentDescription = "Set Menu")
            }
        }
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 64.dp), modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            items(dicesOnScreen){
                DiceItem(imageResource = it.getImageResource())
            }
        }
        Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
            Button(onClick = { dicesOnScreen.clear() }) {
                Text(text = "Delete")
            }
            Button(onClick = { dicesOnScreen.add(Dice(6, "blue")) }) {
                Text(text = "Dice")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Roll")
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewSetUi(){
    MainUi()
}