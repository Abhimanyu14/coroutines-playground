package com.makeappssimple.abhimanyu.coroutinesplayground.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.makeappssimple.abhimanyu.coroutinesplayground.android.navigation.MyNavHost

@Composable
internal fun MyApp(
) {
    val navHostController = rememberNavController()

    MyNavHost(
        navHostController = navHostController,
    )
}
