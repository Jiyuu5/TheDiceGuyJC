package de.rockbiter.thediceguy.ui

import androidx.lifecycle.ViewModel
import de.rockbiter.thediceguy.model.Dice
import de.rockbiter.thediceguy.model.DiceSet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Timer
import kotlin.concurrent.fixedRateTimer

private const val MAX_NUMBER_OF_DICE = 30



class SetViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SetUiState())
    val uiState: StateFlow<SetUiState> = _uiState.asStateFlow()

    private lateinit var timer: Timer

    fun clearDiceSet(){
        _uiState.update { currentState ->
            currentState.copy(
                activeDiceSet = DiceSet(uiState.value.activeDiceSet.name, listOf()),
                scoreAll = 0,
                scoreRed = 0,
                scoreWhite = 0,
                scoreGreen = 0,
                scoreBlue = 0
            )

        }
    }

    fun openDiceDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                isDiceDialogOpen = true
            )
        }
    }

    fun closeDiceDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                isDiceDialogOpen = false
            )
        }
        calculateScores()
    }

    fun addDice(color: String) {

        val dice = Dice(6, color)
        val tempDiceSetList = _uiState.value.activeDiceSet.diceList.toMutableList()
        if (tempDiceSetList.size < MAX_NUMBER_OF_DICE){
            tempDiceSetList.add(dice)
            val tempDiceSet = DiceSet(_uiState.value.activeDiceSet.name, tempDiceSetList)
            _uiState.update { currentState ->
                currentState.copy(
                    activeDiceSet = tempDiceSet
                )
            }
        } else {
            // TODO: Implement Toast Message (don't know how to handle context in the ViewModel)
        }

    }

    fun rollDice(){
        if (uiState.value.activeDiceSet.diceList.isNotEmpty()){
            if (uiState.value.isRollButtonClickedFirst){
                _uiState.update { currentStatus ->
                    currentStatus.copy(
                        isRollButtonClickedFirst = false,
                        textRollButton = "Stop"
                    )
                }
                timer = fixedRateTimer(period = 100L){
                    val tempDiceSetList = _uiState.value.activeDiceSet.diceList.toMutableList()
                    for (dice in tempDiceSetList){
                        dice.roll()
                    }
                    tempDiceSetList.shuffle()
                    val tempDiceSet = DiceSet(_uiState.value.activeDiceSet.name, tempDiceSetList)
                    _uiState.update { currentState ->
                        currentState.copy(
                            activeDiceSet = tempDiceSet
                        )
                    }
                }
            } else {
                _uiState.update { currentStatus ->
                    currentStatus.copy(
                        isRollButtonClickedFirst = true,
                        textRollButton = "Roll"

                    )
                }
                timer.cancel()
            }
        }



//        val tempDiceSetList = _uiState.value.activeDiceSet.diceList.toMutableList()
//        for (dice in tempDiceSetList){
//            dice.roll()
//        }
//        tempDiceSetList.shuffle()
//        val tempDiceSet = DiceSet(_uiState.value.activeDiceSet.name, tempDiceSetList)
//        _uiState.update { currentState ->
//            currentState.copy(
//                activeDiceSet = tempDiceSet
//            )
//        }


        calculateScores()
    }

    private fun calculateScores(){
        val tempDiceSetList = uiState.value.activeDiceSet.diceList
        var sum = 0
        var sumWhite = 0
        var sumRed = 0
        var sumBlue = 0
        var sumGreen = 0
        for (dice in tempDiceSetList){
            sum += dice.getValue()
            if (dice.getColor()== "white"){
                sumWhite += dice.getValue()
            }
            if (dice.getColor()== "red"){
                sumRed += dice.getValue()
            }
            if (dice.getColor()== "blue"){
                sumBlue += dice.getValue()
            }
            if (dice.getColor()== "green"){
                sumGreen += dice.getValue()
            }
        }
        _uiState.update { currentState ->
            currentState.copy(
                scoreAll = sum,
                scoreWhite = sumWhite,
                scoreRed = sumRed,
                scoreBlue = sumBlue,
                scoreGreen = sumGreen
            )

        }
    }
}