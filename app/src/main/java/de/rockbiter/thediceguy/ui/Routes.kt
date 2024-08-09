package de.rockbiter.thediceguy.ui

sealed class Routes(val route: String) {
    object Set1 : Routes("set1")
    object Set2 : Routes("set2")
    object Set3 : Routes("set3")
    object HistoryUi : Routes("history")
    object MenuUi : Routes("mainMenu")
}