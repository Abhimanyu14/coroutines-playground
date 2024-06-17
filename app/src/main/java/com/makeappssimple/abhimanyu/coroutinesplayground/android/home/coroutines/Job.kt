package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun jobSample() {
    runBlocking {
        Log.e("Abhi", "runBlocking main ${threadName()}")

        val job = launch {
            Log.e("Abhi", "job launched ${threadName()}")
            val task1 = runBlocking {
                Log.e("Abhi", "task1 ${threadName()}")
                // simulate a background task
                delay(1000)
                Log.e("Abhi", "task1 complete ${threadName()}")
            }

            val task2 = runBlocking {
                Log.e("Abhi", "task2 ${threadName()}")
                // simulate a background task
                delay(1000)
                Log.e("Abhi", "task2 complete ${threadName()}")
            }
        }

        Log.e("Abhi", "Start job ${threadName()}")
        job.join()
        Log.e("Abhi", "Program ends ${threadName()}")
    }
}
