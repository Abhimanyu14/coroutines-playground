package com.makeappssimple.abhimanyu.coroutinesplayground.android.home.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

public fun threadInfo(): String {
    return "Thread Name => ${Thread.currentThread().name}"
}

public fun CoroutineScope.coroutineInfo(): String {
    return "Scope => $this \n Context => ${this.coroutineContext} \n Job => ${this.coroutineContext[Job]}  "
}

public fun CoroutineScope.logInfo(string: String) {
    Log.e("Abhi", "$string \n ${threadInfo()} \n ${coroutineInfo()}")
}
