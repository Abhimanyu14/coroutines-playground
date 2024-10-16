package com.makeappssimple.abhimanyu.coroutinesplayground.android.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
public fun HomeScreen(
    screenViewModel: HomeScreenViewModel = hiltViewModel(),
) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                onClick = {
                    screenViewModel.crashApp()
                }
            ) {
                Text("Crash App")
            }
        }
    }
}
