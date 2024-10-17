package com.makeappssimple.abhimanyu.coroutinesplayground.android.home

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

internal class HomeScreenViewModelTest {
    @Test
    fun crashApp() = runTest {
        var exception: Throwable? = null
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            exception = throwable
        }

        val standardTestDispatcher: TestDispatcher = StandardTestDispatcher(
            scheduler = testScheduler,
        )
        val testScope = CoroutineScope(
            standardTestDispatcher + coroutineExceptionHandler + SupervisorJob()
        )
        val homeScreenViewModel = HomeScreenViewModel(
            coroutineScope = testScope,
        )
        val job = homeScreenViewModel.crashApp()
        job.join()

        Assert.assertEquals(
            true,
            exception is IllegalStateException,
        )
        Assert.assertEquals(
            "Crash App Test",
            exception?.message,
        )
    }
}
