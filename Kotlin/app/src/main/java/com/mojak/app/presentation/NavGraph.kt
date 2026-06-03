package com.mojak.app.presentation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mojak.app.presentation.start.StartPage
import com.mojak.app.presentation.sheetCreate.SheetCreatePage
import com.mojak.app.presentation.composition.compositionScreen
import com.mojak.app.presentation.sheetCreate.sheetCreateViewModel

sealed class Screen(val route: String){
    object Start : Screen("start")
    object SheetCreate : Screen("sheet_create")
    object compositionScreen : Screen("composition_screen")


}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    val viewModel: sheetCreateViewModel = viewModel()

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
                onClick = {
                    navController.navigate(Screen.compositionScreen.route)
                },
                viewModel = viewModel
            )
        }
        composable(Screen.compositionScreen.route){
            compositionScreen(sheet = viewModel.createSheet())
        }
    }
}