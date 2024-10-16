package com.makeappssimple.abhimanyu.coroutinesplayground.android.exception

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.RuntimeException

internal class CoroutineExceptionHandler {
    @Test
    fun uncaughtException() {
        runBlocking {
            val scope = CoroutineScope(Dispatchers.Default)
            val job = scope.launch {
                delay(50)
                throw RuntimeException()
            }
            job.join()
        }
        Thread.sleep(100)
        println("test completed")
    }

    @Test
    fun caughtException() {
        runBlocking {

            val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
                println("Caught exception: $throwable")
            }

            val scope = CoroutineScope(Dispatchers.Default + coroutineExceptionHandler)
            val job = scope.launch {
                delay(50)
                throw RuntimeException()
            }
            job.join()
        }
        Thread.sleep(100)
        println("test completed")
    }
}
