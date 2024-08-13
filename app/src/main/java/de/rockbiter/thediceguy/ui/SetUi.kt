package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.Image
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.rockbiter.thediceguy.R
import de.rockbiter.thediceguy.model.Dice


@Composable
fun SetUi(set: Int, setViewModel: SetViewModel = viewModel()) {
    val setUiState by setViewModel.uiState.collectAsState()

    val diceOnScreen = remember { mutableStateListOf<Dice>() }
    var scoreAll by remember { mutableIntStateOf(0) }
    var isAlertDialogOpen by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(text = "Set $set", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = scoreAll.toString(), modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.more_vert_32),
                    contentDescription = "Set Menu"
                )
            }
        }

        LazyVerticalGrid(
            state = LazyGridState(),
            columns = GridCells.Adaptive(minSize = 48.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(diceOnScreen) {
                DiceItem(imageResource = it.getImageResource(), Modifier.padding(4.dp))
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { diceOnScreen.clear() }) {
                Text(text = "Delete")
            }
            Button(onClick = {
                isAlertDialogOpen = true
            }) {
                Text(text = "Dice")
            }
            Button(onClick = {
                var sum = 0
                for (dice in diceOnScreen) {
                    dice.roll()
                    sum += dice.getValue()
                }
                diceOnScreen.shuffle()
                scoreAll = sum
            }) {
                Text(text = "Roll")
            }
        }
    }
    if (isAlertDialogOpen) {
        AlertDialog(
            title = { Text(text = "Add Dice") },
            text = {
                Row {
                    IconButton(onClick = {
                        diceOnScreen.add(Dice(6, "white"))
                        var sum = 0
                        for (dice in diceOnScreen) {
                            sum += dice.getValue()
                        }
                        scoreAll = sum
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3),
                            contentDescription = "White Dice"
                        )
                    }

                    IconButton(onClick = {
                        diceOnScreen.add(Dice(6, "blue"))
                        var sum = 0
                        for (dice in diceOnScreen) {
                            sum += dice.getValue()
                        }
                        scoreAll = sum
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3_blue),
                            contentDescription = "White Dice"
                        )
                    }

                    IconButton(onClick = {
                        diceOnScreen.add(Dice(6, "red"))
                        var sum = 0
                        for (dice in diceOnScreen) {
                            sum += dice.getValue()
                        }
                        scoreAll = sum
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3_red),
                            contentDescription = "White Dice"

                        )
                    }

                    IconButton(onClick = {
                        diceOnScreen.add(Dice(6, "green"))
                        var sum = 0
                        for (dice in diceOnScreen) {
                            sum += dice.getValue()
                        }
                        scoreAll = sum
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3_green),
                            contentDescription = "White Dice"
                        )
                    }
                }

            },
            onDismissRequest = { isAlertDialogOpen = false },
            confirmButton = {
                Button(onClick = { isAlertDialogOpen = false }
                ) {
                    Text(text = "Close")
                }
            })
    }


}


@Preview(showBackground = true)
@Composable
fun PreviewSetUi() {
    MainUi()
}