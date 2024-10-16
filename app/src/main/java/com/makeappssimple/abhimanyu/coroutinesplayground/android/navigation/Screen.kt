package com.makeappssimple.abhimanyu.coroutinesplayground.android.navigation

public sealed class Screen(
    public val route: String,
) {
    public data object Home : Screen(
        route = "home",
    )
}
