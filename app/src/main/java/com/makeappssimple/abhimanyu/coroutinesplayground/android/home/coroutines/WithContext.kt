package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun withContextSample() {
    coroutineScope {
        logInfo("runBlocking starting")

        val job1 = launch(Dispatchers.Main) {
            logInfo("job1 launch")
            // simulate a background task
            withContext(Dispatchers.Default) {
                logInfo("withContext")
                delay(1000)
            }

            logInfo("job1 complete")
        }

        joinAll(job1)
        logInfo("runBlocking complete")
    }
}
