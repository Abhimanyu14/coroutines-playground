package com.makeappssimple.abhimanyu.coroutinesplayground.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.makeappssimple.abhimanyu.coroutinesplayground.android.home.HomeScreen

@Composable
internal fun MyNavHost(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen()
        }
    }
}
