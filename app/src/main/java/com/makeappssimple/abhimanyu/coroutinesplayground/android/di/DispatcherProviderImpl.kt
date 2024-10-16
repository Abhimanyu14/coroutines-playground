package com.makeappssimple.abhimanyu.coroutinesplayground.android.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

public class DispatcherProviderImpl(
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
    @MainDispatcher mainDispatcher: CoroutineDispatcher,
    @MainImmediateDispatcher mainImmediateDispatcher: CoroutineDispatcher,
    @UnconfinedDispatcher unconfinedDispatcher: CoroutineDispatcher,
) : DispatcherProvider {
    override val default: CoroutineDispatcher = defaultDispatcher
    override val io: CoroutineDispatcher = ioDispatcher
    override val main: CoroutineDispatcher = mainDispatcher
    override val mainImmediate: CoroutineDispatcher = mainImmediateDispatcher
    override val unconfined: CoroutineDispatcher = unconfinedDispatcher

    override suspend fun <T> executeOnIoDispatcher(
        block: suspend CoroutineScope.() -> T,
    ): T {
        return withContext(
            context = io,
            block = block,
        )
    }
}
