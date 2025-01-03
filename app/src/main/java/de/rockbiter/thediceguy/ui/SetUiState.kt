package de.rockbiter.thediceguy.ui

import de.rockbiter.thediceguy.model.DiceSet

data class SetUiState(
    val scoreAll: Int = 0,
    val scoreWhite: Int = 0,
    val scoreRed: Int = 0,
    val scoreBlue: Int = 0,
    val scoreGreen: Int = 0,
    val isScoreViewEnabled: Boolean = true,
    val isDiceCountViewEnabled: Boolean = true,
    val isDiceDialogOpen: Boolean = false,
    val isRollButtonClickedFirst: Boolean = true,
    val textRollButton: String = "Roll",
    val activeDiceSet: DiceSet = DiceSet("", listOf()),
)
