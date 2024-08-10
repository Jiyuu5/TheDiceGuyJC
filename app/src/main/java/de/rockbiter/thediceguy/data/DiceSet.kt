package de.rockbiter.thediceguy.data

import de.rockbiter.thediceguy.model.Dice

data class DiceSet(val name: String, val diceArrayList: ArrayList<Dice>)

var diceSets = arrayListOf(
    DiceSet("Set 1", arrayListOf(Dice(6 ))),
    DiceSet("Set 2", arrayListOf(Dice(6, "green"), Dice(6, "blue"))),
    DiceSet("Set 3", arrayListOf(Dice(6, "red"), Dice(6, "red"), Dice(6, "red"), Dice(6, "blue"), Dice(6, "blue")))
)

