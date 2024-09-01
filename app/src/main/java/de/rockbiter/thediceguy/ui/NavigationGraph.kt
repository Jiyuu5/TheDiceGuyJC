package de.rockbiter.thediceguy.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(
    navController: NavHostController,
    menuViewModel: MenuViewModel = viewModel()
){
    NavHost(navController = navController, startDestination = Routes.Set1.route) {
        composable(Routes.Set1.route){
            SetUi()
        }
        composable(Routes.Set2.route){
            SetUi()
        }
        composable(Routes.Set3.route){
            SetUi()
        }
        composable(Routes.HistoryUi.route){
            HistoryUi()
        }
        composable(Routes.MenuUi.route){
            MenuUi(menuViewModel.getVersionHistory() ,menuViewModel)
        }
    }
}