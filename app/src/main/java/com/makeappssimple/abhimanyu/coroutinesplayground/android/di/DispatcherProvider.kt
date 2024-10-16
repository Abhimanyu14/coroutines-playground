package com.makeappssimple.abhimanyu.coroutinesplayground.android.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

public interface DispatcherProvider {
    public val default: CoroutineDispatcher
    public val io: CoroutineDispatcher
    public val main: CoroutineDispatcher
    public val mainImmediate: CoroutineDispatcher
    public val unconfined: CoroutineDispatcher

    public suspend fun <T> executeOnIoDispatcher(
        block: suspend CoroutineScope.() -> T,
    ): T
}
