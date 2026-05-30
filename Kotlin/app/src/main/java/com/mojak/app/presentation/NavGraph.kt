package com.mojak.app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mojak.app.presentation.start.StartPage
import com.mojak.app.presentation.sheetCreate.SheetCreatePage

sealed class Screen(val route: String){
    object Start : Screen("start")
    object SheetCreate : Screen("sheet_create")

}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
    ) {
        composable(Screen.Start.route) {
            StartPage(
                onClick = {
                    navController.navigate(Screen.SheetCreate.route)
                }
            )
        }
        composable(Screen.SheetCreate.route){
            SheetCreatePage(
                // onClick = {
                //     // 악보 페이지로 이동
                // }
            )
        }
    }
}