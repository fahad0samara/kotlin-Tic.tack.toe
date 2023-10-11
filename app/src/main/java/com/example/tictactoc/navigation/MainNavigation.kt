package com.example.tictactoc.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tictactoc.data.GameViewModel
import com.example.tictactoc.screen.StartScreen


@Composable
fun MainNavigation() {
    val navHostController= rememberNavController()

    NavHost(navController =navHostController, startDestination = START_SCREEN) {
        composable(START_SCREEN) {
            val viewModel = viewModel<GameViewModel>()
            StartScreen(
                viewModel,
                navHostController
            )
        }




    }


}



const val START_SCREEN="start_screen"
const val HOME_SCREEN="home_screen"
const val CHAT_SCREEN="chat_screen"
