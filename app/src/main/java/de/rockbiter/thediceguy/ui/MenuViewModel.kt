package de.rockbiter.thediceguy.ui



import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MenuViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(MenuUiState())
    val uiState: StateFlow<MenuUiState> = _uiState.asStateFlow()

    fun openVersionHistory() {
        _uiState.update { currentState ->
            currentState.copy(
                isVersionHistoryOpen = true
            )
        }
    }

    fun closeVersionHistory() {
        _uiState.update { currentState ->
            currentState.copy(
                isVersionHistoryOpen = false
            )
        }
    }

    fun getVersionHistory(): String {
        val versionHistoryString = "This will be the version history..."





        return versionHistoryString
    }
}