package de.rockbiter.thediceguy.data

import de.rockbiter.thediceguy.model.Dice
import de.rockbiter.thediceguy.model.DiceSet


var dicePresets = listOf(
    DiceSet("Preset 1", listOf(Dice(6, "white"))),
    DiceSet("Preset 2", listOf(Dice(6, "green"), Dice(6,"blue"))),
    DiceSet("Preset 3", listOf(Dice(6, "red"), Dice(6,"blue")))
)
