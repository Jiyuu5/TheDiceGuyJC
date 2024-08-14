package de.rockbiter.thediceguy.ui

import androidx.lifecycle.ViewModel
import de.rockbiter.thediceguy.data.dicePresets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SetViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SetUiState())
    val uiState: StateFlow<SetUiState> = _uiState.asStateFlow()

    init {
        loadSetPresets()
    }

    private fun loadSetPresets() {
            _uiState.update { currentState ->
                currentState.copy(
                    activeDiceSet = dicePresets[0]
                )
            }
    }
}