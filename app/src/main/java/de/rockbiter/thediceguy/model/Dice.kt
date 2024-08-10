package de.rockbiter.thediceguy.model

import de.rockbiter.thediceguy.R
import kotlin.random.Random

class Dice (type: Int, color: String = "white"){
    private var value: Int = 1
    private var diceType: Int = type
    private var imageResources = intArrayOf(
        R.drawable.dice6_1,
        R.drawable.dice6_2,
        R.drawable.dice6_3,
        R.drawable.dice6_4,
        R.drawable.dice6_5,
        R.drawable.dice6_6,
    )

    init {
        if(color == "blue"){
            imageResources = intArrayOf(
                R.drawable.dice6_1_blue,
                R.drawable.dice6_2_blue,
                R.drawable.dice6_3_blue,
                R.drawable.dice6_4_blue,
                R.drawable.dice6_5_blue,
                R.drawable.dice6_6_blue
            )
        } else if (color == "green") {
            imageResources = intArrayOf(
                R.drawable.dice6_1_green,
                R.drawable.dice6_2_green,
                R.drawable.dice6_3_green,
                R.drawable.dice6_4_green,
                R.drawable.dice6_5_green,
                R.drawable.dice6_6_green
            )
        } else if (color == "red"){
            imageResources = intArrayOf(
                R.drawable.dice6_1_red,
                R.drawable.dice6_2_red,
                R.drawable.dice6_3_red,
                R.drawable.dice6_4_red,
                R.drawable.dice6_5_red,
                R.drawable.dice6_6_red
            )
        }
    }

    fun roll():Int{
        value = Random.nextInt(1, diceType)
        return imageResources[value - 1]
    }

    fun getValue():Int{
        return value
    }

    fun getImageResource():Int{
        return imageResources[value - 1]
    }


}