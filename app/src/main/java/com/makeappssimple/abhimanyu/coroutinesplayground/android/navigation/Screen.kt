package com.makeappssimple.abhimanyu.coroutinesplayground.android.navigation

sealed class Screen(
    val route: String,
) {
    data object Home : Screen(
        route = "home",
    )
}
