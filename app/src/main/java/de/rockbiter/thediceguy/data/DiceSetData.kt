package de.rockbiter.thediceguy.data

import de.rockbiter.thediceguy.model.Dice
import de.rockbiter.thediceguy.model.DiceSet


var dicePresets = listOf(
    DiceSet(listOf(Dice(6, "white"))),
    DiceSet(listOf(Dice(6, "green"), Dice(6,"blue"))),
    DiceSet(listOf(Dice(6, "red"), Dice(6,"blue")))
)
