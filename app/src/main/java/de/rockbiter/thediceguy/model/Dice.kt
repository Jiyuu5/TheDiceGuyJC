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
        }
    }

    fun roll():Int{
        value = Random.nextInt(1, diceType)
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