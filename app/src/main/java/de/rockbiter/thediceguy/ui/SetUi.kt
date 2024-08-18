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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Text(text = setUiState.activeDiceSet.name, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = setUiState.scoreAll.toString(), modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                fontSize = 28.sp
            )
            if (setUiState.scoreRed > 0 && (setUiState.scoreBlue > 0 || setUiState.scoreGreen > 0 || setUiState.scoreWhite > 0 )){
                Text(
                    text = setUiState.scoreRed.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.red),
                    style = TextStyle(shadow = Shadow(color = colorResource(id = R.color.red), offset = Offset.Zero,3.0f))
                )
            }
            if (setUiState.scoreBlue > 0 && (setUiState.scoreRed > 0 || setUiState.scoreGreen > 0 || setUiState.scoreWhite > 0 )){
                Text(
                    text = setUiState.scoreBlue.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.blue),
                    style = TextStyle(shadow = Shadow(color = colorResource(id = R.color.blue), offset = Offset.Zero,3.0f))
                )
            }
            if (setUiState.scoreGreen > 0 && (setUiState.scoreBlue > 0 || setUiState.scoreRed > 0 || setUiState.scoreWhite > 0 )){
                Text(
                    text = setUiState.scoreGreen.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.green),
                    style = TextStyle(shadow = Shadow(color = colorResource(id = R.color.green), offset = Offset.Zero,3.0f))
                )
            }
            if (setUiState.scoreWhite > 0 && (setUiState.scoreBlue > 0 || setUiState.scoreGreen > 0 || setUiState.scoreRed > 0 )){
                Text(
                    text = setUiState.scoreWhite.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.white),
                    style = TextStyle(shadow = Shadow(color = colorResource(id = R.color.white), offset = Offset.Zero,3.0f))
                )
            }


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
            items(setUiState.activeDiceSet.diceList) {
                DiceItem(imageResource = it.getImageResource(), Modifier.padding(4.dp))
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { setViewModel.clearDiceSet() }) {
                Text(text = "Delete")
            }
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
    if (setUiState.isDiceDialogOpen) {
        AlertDialog(
            title = { Text(text = "Add Dice") },
            text = {
                Row {
                    IconButton(onClick = {
                        setViewModel.addDice("white")
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3),
                            contentDescription = "White Dice"
                        )
                    }

                    IconButton(onClick = {
                        setViewModel.addDice("blue")
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3_blue),
                            contentDescription = "White Dice"
                        )
                    }

                    IconButton(onClick = {
                        setViewModel.addDice("red")
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3_red),
                            contentDescription = "White Dice"

                        )
                    }

                    IconButton(onClick = {
                        setViewModel.addDice("green")
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.dice6_3_green),
                            contentDescription = "White Dice"
                        )
                    }
                }

            },
            onDismissRequest = {
                setViewModel.closeDiceDialog()
            },
            confirmButton = {
                Button(onClick = {
                    setViewModel.closeDiceDialog()
                }
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