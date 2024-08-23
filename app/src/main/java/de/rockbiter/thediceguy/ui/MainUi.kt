package de.rockbiter.thediceguy.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainUi() {
    val navController : NavHostController = rememberNavController()


    Scaffold (
        bottomBar = {BottomNavigationBar(navController)},
        modifier = Modifier
    ){
        contentPadding ->
        Row (modifier = Modifier.padding(contentPadding)){
            NavigationGraph(navController = navController)
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController){
    val screens = listOf(
        BottomNavItem.SetPreset1,
        BottomNavItem.SetPreset2,
        BottomNavItem.SetPreset3,
        BottomNavItem.History,
        BottomNavItem.MainMenu
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            NavigationBarItem(
                label = { Text(text = screen.label)},
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route){
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                } },
                icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = "") })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UiPreview(){
    MainUi()
}