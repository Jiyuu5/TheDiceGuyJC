package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rockbiter.thediceguy.R
import de.rockbiter.thediceguy.model.Dice


@Composable
fun SetUi(set: Int){

    val dicesOnScreen = remember {
        mutableStateListOf<Dice>()
    }
    var score by remember {
        mutableIntStateOf(0)
    }

    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()) {
        Text(text = "Set $set", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()){
            Text(text = score.toString(), modifier = Modifier
                .fillMaxWidth()
                .weight(1f))
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.more_vert_32), contentDescription = "Set Menu")
            }
        }

        LazyVerticalGrid(state = LazyGridState(), columns = GridCells.Adaptive(minSize = 48.dp), modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            items(dicesOnScreen){
                DiceItem(imageResource = it.getImageResource(), Modifier.padding(4.dp))
            }
        }
        Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
            Button(onClick = { dicesOnScreen.clear() }) {
                Text(text = "Delete")
            }
            Button(onClick = {
                dicesOnScreen.add(Dice(6, "blue"))
                var sum = 0
                for (dice in dicesOnScreen){
                    sum += dice.getValue()
                }
                score = sum
            }) {
                Text(text = "Dice")
            }
            Button(onClick = {
                var sum = 0
                for (dice in dicesOnScreen){
                    dice.roll()
                    sum += dice.getValue()
                }
                dicesOnScreen.shuffle()
                score = sum
            }) {
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