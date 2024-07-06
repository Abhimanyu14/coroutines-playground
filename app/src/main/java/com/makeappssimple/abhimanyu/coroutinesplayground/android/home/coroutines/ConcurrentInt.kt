package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger

internal suspend fun concurrentIntSample() {
    val total = AtomicInteger()
    coroutineScope {
        withContext(Dispatchers.Default) {
            repeat(100_000) {
                launch {
                    // delay(100)
                    total.getAndIncrement()
                }
            }
        }
        logInfo("Total: $total")
    }
}
