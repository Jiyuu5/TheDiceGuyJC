package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import de.rockbiter.thediceguy.R


@Composable
fun SetUi(set: Int, setViewModel: SetViewModel = viewModel()) {
    val setUiState by setViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        //Text(text = setUiState.activeDiceSet.name, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        ) {
            if (setUiState.activeDiceSet.diceList.isNotEmpty()) {
                Text(
                    text = setUiState.scoreAll.toString(), modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 28.sp
                )
            }
            if (setUiState.scoreRed > 0 && (setUiState.scoreBlue > 0 || setUiState.scoreGreen > 0 || setUiState.scoreWhite > 0)) {
                Text(
                    text = setUiState.scoreRed.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.red)
                )
            }
            if (setUiState.scoreBlue > 0 && (setUiState.scoreRed > 0 || setUiState.scoreGreen > 0 || setUiState.scoreWhite > 0)) {
                Text(
                    text = setUiState.scoreBlue.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.blue)
                )
            }
            if (setUiState.scoreGreen > 0 && (setUiState.scoreBlue > 0 || setUiState.scoreRed > 0 || setUiState.scoreWhite > 0)) {
                Text(
                    text = setUiState.scoreGreen.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.green)
                )
            }
            if (setUiState.scoreWhite > 0 && (setUiState.scoreBlue > 0 || setUiState.scoreGreen > 0 || setUiState.scoreRed > 0)) {
                Text(
                    text = setUiState.scoreWhite.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp
                )
            }
            if (setUiState.activeDiceSet.diceList.isNotEmpty()) {
                IconButton(
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.more_vert_32),
                        contentDescription = "Set Menu"
                    )
                }
            }
        }

        LazyVerticalGrid(
            state = LazyGridState(),
            columns = GridCells.Fixed(6),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(setUiState.activeDiceSet.diceList) {
                DiceItem(imageResource = it.getImageResource(), Modifier.padding(4.dp))
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                setViewModel.openDiceDialog()
            }) {
                Text(text = "Dice")
            }
            Button(onClick = {
                setViewModel.rollDice()
            }) {
                Text(text = setUiState.textRollButton)
            }
        }
    }
//    if (setUiState.isDiceDialogOpen) {
//        AlertDialog(
//            title = { Text(text = "Dice Menu", fontSize = 20.sp) },
//            text =
//            {
//                Column {
//                    Row {
//                        IconButton(onClick = {
//                            setViewModel.addDice(6,"white")
//                        }) {
//                            Image(
//                                painter = painterResource(id = R.drawable.dice6_3),
//                                contentDescription = "White D6 Dice"
//                            )
//                        }
//
//                        IconButton(onClick = {
//                            setViewModel.addDice(6,"blue")
//                        }) {
//                            Image(
//                                painter = painterResource(id = R.drawable.dice6_3_blue),
//                                contentDescription = "Blue D6 Dice"
//                            )
//                        }
//
//                        IconButton(onClick = {
//                            setViewModel.addDice(6,"red")
//                        }) {
//                            Image(
//                                painter = painterResource(id = R.drawable.dice6_3_red),
//                                contentDescription = "Red D6 Dice"
//
//                            )
//                        }
//
//                        IconButton(onClick = {
//                            setViewModel.addDice(6,"green")
//                        }) {
//                            Image(
//                                painter = painterResource(id = R.drawable.dice6_3_green),
//                                contentDescription = "Green D6 Dice"
//                            )
//                        }
//
//                        IconButton(onClick = {
//                            setViewModel.addDice(4,"D4_white")
//                        }) {
//                            Image(
//                                painter = painterResource(id = R.drawable.dice4_3),
//                                contentDescription = "White D4 Dice"
//                            )
//                        }
//                    }
//                    Row (
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ){
//                        TextButton(onClick = { setViewModel.clearDiceSet() }) {
//                            Text(text = "Delete All")
//                        }
//                        TextButton(onClick = { setViewModel.closeDiceDialog() }) {
//                            Text(text = "Dismiss")
//                        }
//                    }
//                }
//
//
//            },
//            onDismissRequest = {
//                setViewModel.closeDiceDialog()
//            },
//            confirmButton = { })
//    }
    if (setUiState.isDiceDialogOpen) {
        Dialog(onDismissRequest = { setViewModel.closeDiceDialog() }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Dice Menu", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
                    Row {
                        IconButton(onClick = {
                            setViewModel.addDice(6, "white")
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.dice6_3),
                                contentDescription = "White D6 Dice"
                            )
                        }

                        IconButton(onClick = {
                            setViewModel.addDice(6, "blue")
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.dice6_3_blue),
                                contentDescription = "Blue D6 Dice"
                            )
                        }

                        IconButton(onClick = {
                            setViewModel.addDice(6, "red")
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.dice6_3_red),
                                contentDescription = "Red D6 Dice"

                            )
                        }

                        IconButton(onClick = {
                            setViewModel.addDice(6, "green")
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.dice6_3_green),
                                contentDescription = "Green D6 Dice"
                            )
                        }
                    }
                    Row {
                        IconButton(onClick = {
                            setViewModel.addDice(4, "D4_white")
                        }) {
                            Image(
                                painter = painterResource(id = R.drawable.dice4_3),
                                contentDescription = "White D4 Dice"
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextButton(onClick = { setViewModel.clearDiceSet() }) {
                            Text(text = "Delete All")
                        }
                        TextButton(onClick = { setViewModel.closeDiceDialog() }) {
                            Text(text = "Dismiss")
                        }
                    }
                }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun PreviewSetUi() {
    MainUi()
}