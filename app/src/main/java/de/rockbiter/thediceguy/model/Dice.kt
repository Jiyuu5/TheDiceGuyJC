package de.rockbiter.thediceguy.model
import de.rockbiter.thediceguy.data.diceImageResources
import kotlin.random.Random

class Dice (type: Int, private var color: String = "white"){
    private var value: Int = 1
    private var diceType: Int = type
    private var imageResources = diceImageResources["white"]

    init {
        when (color) {
            "blue" -> {
                imageResources = diceImageResources["blue"]
            }
            "green" -> {
                imageResources = diceImageResources["green"]
            }
            "red" -> {
                imageResources = diceImageResources["red"]
            }
            "D4_white" -> {
                imageResources = diceImageResources["D4_white"]
            }
            "D4_blue" -> {
                imageResources = diceImageResources["D4_blue"]
            }
            "D4_green" -> {
                imageResources = diceImageResources["D4_green"]
            }
            "D4_red" -> {
                imageResources = diceImageResources["D4_red"]
            }
        }
    }

    fun roll():Int{
        value = Random.nextInt(1, diceType + 1)
        return imageResources?.get(value - 1) ?: 1
    }

    fun getValue():Int{
        return value
    }

    fun getImageResource():Int{
        return imageResources?.get(value - 1) ?: 1
    }

    fun getColor():String{
        return this.color
    }

}