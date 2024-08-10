package de.rockbiter.thediceguy.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Routes.Set1.route) {
        composable(Routes.Set1.route){
            SetUi(set = 0)
        }
        composable(Routes.Set2.route){
            SetUi(set = 1)
        }
        composable(Routes.Set3.route){
            SetUi(set = 2)
        }
        composable(Routes.HistoryUi.route){
            HistoryUi()
        }
        composable(Routes.MenuUi.route){
            MenuUi()
        }
    }
}