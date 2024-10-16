package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

public suspend fun launchSample() {
    coroutineScope {
        Log.e("Abhi", "runBlocking main ${threadInfo()}")

        val job = launch {
            Log.e("Abhi", "job launched ${threadInfo()}")
            val task1 = runBlocking {
                Log.e("Abhi", "task1 ${threadInfo()}")
                // simulate a background task
                delay(1000)
                Log.e("Abhi", "task1 complete ${threadInfo()}")
            }

            val task2 = runBlocking {
                Log.e("Abhi", "task2 ${threadInfo()}")
                // simulate a background task
                delay(1000)
                Log.e("Abhi", "task2 complete ${threadInfo()}")
            }
        }

        Log.e("Abhi", "Start job ${threadInfo()}")
        // job.join()
        Log.e("Abhi", "Program ends ${threadInfo()}")
    }
}
