package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.withContext

suspend fun asyncSample() {
    coroutineScope {
        val total = 0
        logInfo("runBlocking starting")

        val job1: Job = async(Dispatchers.Main) {
            logInfo("job1 launch")
            // simulate a background task
            withContext(Dispatchers.Default) {
                logInfo("withContext")
                delay(1000)
            }

            logInfo("job1 complete")
        }

        joinAll(job1)
        logInfo("runBlocking complete ${job1}")
    }
}
