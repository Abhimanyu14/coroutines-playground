package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

public fun runBlockingSample() {
    runBlocking {
        logInfo("main runBlocking")

        val task1 = runBlocking {
            logInfo( "task1 runBlocking")
            // simulate a background task
            delay(1000)
            logInfo( "task1 complete")
        }

        val task2 = runBlocking {
            logInfo( "task2 runBlocking")
            // simulate a background task
            delay(1000)
            logInfo( "task2 complete")
        }

        logInfo( "Program ends")
    }
}
