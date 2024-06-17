package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun runBlockingSample() {
    runBlocking {
        Log.e("Abhi", "main runBlocking ${threadName()}")

        val task1 = runBlocking {
            Log.e("Abhi", "task1 runBlocking ${threadName()}")
            // simulate a background task
            delay(1000)
            Log.e("Abhi", "task1 complete ${threadName()}")
        }

        val task2 = runBlocking {
            Log.e("Abhi", "task2 runBlocking ${threadName()}")
            // simulate a background task
            delay(1000)
            Log.e("Abhi", "task2 complete ${threadName()}")
        }

        Log.e("Abhi", "Program ends ${threadName()}")
    }
}
