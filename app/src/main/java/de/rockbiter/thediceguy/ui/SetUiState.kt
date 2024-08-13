package de.rockbiter.thediceguy.ui

import de.rockbiter.thediceguy.data.DiceSet

data class SetUiState(
    val scoreAll: Int = 0,
    val scoreRed: Int = 0,
    val scoreBlue: Int = 0,
    val scoreGreen: Int = 0,
    val isDiceDialogOpen: Boolean = false,
    val activeDiceSet: DiceSet = DiceSet(listOf()),
)
