package de.rockbiter.thediceguy.data

import de.rockbiter.thediceguy.model.Dice

data class DiceSet(val diceList: List<Dice>)

var diceSets = listOf(
    DiceSet(listOf(Dice(6, "white"))),
    DiceSet(listOf(Dice(6, "green"), Dice(6,"blue")))
)
