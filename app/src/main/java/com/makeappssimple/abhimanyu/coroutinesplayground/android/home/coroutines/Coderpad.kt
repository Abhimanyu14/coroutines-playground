package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Notes - All coroutines execute on the main thread in the give order
 */
private fun mainDispatcherSample() {
    val dispatcherScope = CoroutineScope(Dispatchers.Main)
    repeat(1000) {
        dispatcherScope.launch(Dispatchers.Main) {
            printThreadData("$it")
        }
    }
}

/**
 * Notes - Coroutines execute on the IO thread pool - 64 threads
 * The order of thread selection is random,
 * but coroutines in a thread maintain the scheduling order.
 */
private fun ioDispatcherSample() {
    val dispatcherScope = CoroutineScope(Dispatchers.IO)
    repeat(1000) {
        dispatcherScope.launch(Dispatchers.IO) {
            printThreadData("$it")
        }
    }
}

/**
 * Notes - Coroutines execute on the IO thread pool - 2 threads
 * The order of thread selection is random,
 * but coroutines in a thread maintain the scheduling order.
 */
private fun defaultDispatcherSample() {
    val dispatcherScope = CoroutineScope(Dispatchers.Default)
    repeat(1000) {
        dispatcherScope.launch(Dispatchers.Default) {
            printThreadData("$it")
        }
    }
}

/**
 * Notes - Unconfined dispatcher uses the same thread it is currently launched on.
 */
private fun unconfinedDispatcherNewSample() {
    val mainDispatcherScope = CoroutineScope(Dispatchers.Main)
    val defaultDispatcherScope = CoroutineScope(Dispatchers.Default)
    val ioDispatcherScope = CoroutineScope(Dispatchers.IO)
    val unconfinedDispatcherScope = CoroutineScope(Dispatchers.Unconfined)

    mainDispatcherScope.launch {
        printThreadData("Main")
        ioDispatcherScope.launch(Dispatchers.IO) {
            printThreadData("Main -> IO -> IO")
        }
        ioDispatcherScope.launch(Dispatchers.Unconfined) {
            printThreadData("Main -> IO -> Unconfined")
        }
    }
}

private fun printThreadData(
    id: String,
) {
    Log.e("Abhi", "Dispatcher $id => ${Thread.currentThread().name}")
}

private fun viewModelScopeSample(
    viewModelScope: CoroutineScope,
) {
    Log.e("Abhi", "Init")
    viewModelScope.launch {
        Log.e("Abhi", "No Dispatcher => ${Thread.currentThread().name}")
    }
    viewModelScope.launch(Dispatchers.Main) {
        Log.e("Abhi", "Main Dispatcher => ${Thread.currentThread().name}")
    }
    viewModelScope.launch(Dispatchers.Main.immediate) {
        Log.e("Abhi", "Main immediate Dispatcher => ${Thread.currentThread().name}")
    }
    viewModelScope.launch(Dispatchers.Default) {
        Log.e("Abhi", "Default Dispatcher => ${Thread.currentThread().name}")
    }
    viewModelScope.launch(Dispatchers.IO) {
        Log.e("Abhi", "IO Dispatcher => ${Thread.currentThread().name}")
    }
    viewModelScope.launch(Dispatchers.Unconfined) {
        Log.e("Abhi", "Unconfined Dispatcher => ${Thread.currentThread().name}")
    }
}

private fun ioDispatcherScopeSample() {
    val ioDispatcherScope = CoroutineScope(Dispatchers.IO)
    ioDispatcherScope.launch {
        Log.e("Abhi", "ioDispatcherScope No Dispatcher => ${Thread.currentThread().name}")
    }
    ioDispatcherScope.launch(Dispatchers.Main) {
        Log.e("Abhi", "ioDispatcherScope Main Dispatcher => ${Thread.currentThread().name}")
    }
    ioDispatcherScope.launch(Dispatchers.Main.immediate) {
        Log.e(
            "Abhi",
            "ioDispatcherScope Main immediate Dispatcher => ${Thread.currentThread().name}"
        )
    }
    ioDispatcherScope.launch(Dispatchers.Default) {
        Log.e("Abhi", "ioDispatcherScope Default Dispatcher => ${Thread.currentThread().name}")
    }
    ioDispatcherScope.launch(Dispatchers.IO) {
        Log.e("Abhi", "ioDispatcherScope IO Dispatcher => ${Thread.currentThread().name}")
    }
    ioDispatcherScope.launch(Dispatchers.Unconfined) {
        Log.e(
            "Abhi",
            "ioDispatcherScope Unconfined Dispatcher => ${Thread.currentThread().name}"
        )
    }
}
