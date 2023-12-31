package com.example.tictactoc.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tictactoc.model.GameViewModel
import com.example.tictactoc.screen.SplashScreen
import com.example.tictactoc.screen.StartScreen


@Composable
fun MainNavigation() {
    val navHostController= rememberNavController()

    NavHost(navController =navHostController, startDestination = "Splash") {
        composable("Splash") {
            SplashScreen(
                   navHostController
            )
        }

        composable("start_screen") {
            val viewModel = viewModel<GameViewModel>()
            StartScreen(
                viewModel,
                navHostController
            )
        }




    }


}





