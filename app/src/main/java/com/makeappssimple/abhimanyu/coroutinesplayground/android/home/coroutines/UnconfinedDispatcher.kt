package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun unconfinedDispatcherSample() {
    coroutineScope {
        withContext(Dispatchers.Default) {
            val coroutineScope = CoroutineScope(Dispatchers.Default)
            coroutineScope.launch {
                logInfo("scope default executes on")
            }
            coroutineScope.launch(Dispatchers.Default + NonCancellable) {
                logInfo("default executes on")
            }
            coroutineScope.launch(Dispatchers.IO) {
                logInfo("IO executes on")
            }
            coroutineScope.launch(Dispatchers.Main) {
                logInfo("main executes on")
            }
            coroutineScope.launch(Dispatchers.Unconfined) {
                logInfo("unconfined executes on")
            }
        }
    }
}
