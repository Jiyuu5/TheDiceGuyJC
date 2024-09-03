package de.rockbiter.thediceguy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Preset(
    @PrimaryKey val id: Int,
    val setId: Int,
    val diceType: Int,
    val diceColor: Int
)
