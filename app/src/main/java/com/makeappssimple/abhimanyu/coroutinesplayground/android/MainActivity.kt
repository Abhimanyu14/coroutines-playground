package com.makeappssimple.abhimanyu.coroutinesplayground.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.makeappssimple.abhimanyu.coroutinesplayground.android.ui.theme.CoroutinesPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutinesPlaygroundTheme {
                MyApp()
            }
        }
    }
}
