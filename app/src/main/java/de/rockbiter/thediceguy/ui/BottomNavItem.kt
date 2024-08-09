package de.rockbiter.thediceguy.ui

import de.rockbiter.thediceguy.R

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    data object SetPreset1 : BottomNavItem("set1", R.drawable.looks_one, "Set 1")
    data object SetPreset2 : BottomNavItem("set2", R.drawable.looks_two, "Set 2")
    data object SetPreset3 : BottomNavItem("set3", R.drawable.looks_three, "Set 3")
    data object History : BottomNavItem("history", R.drawable.history_24, "History")
    data object MainMenu : BottomNavItem("mainMenu", R.drawable.menu_24, "Menu")
}