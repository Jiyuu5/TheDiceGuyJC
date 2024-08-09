package de.rockbiter.thediceguy.ui

sealed class Routes(val route: String) {
    data object Set1 : Routes("set1")
    data object Set2 : Routes("set2")
    data object Set3 : Routes("set3")
    data object HistoryUi : Routes("history")
    data object MenuUi : Routes("mainMenu")
}