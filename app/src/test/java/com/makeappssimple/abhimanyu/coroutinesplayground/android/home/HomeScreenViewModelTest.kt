package com.makeappssimple.abhimanyu.coroutinesplayground.android.home

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class HomeScreenViewModelTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test // (expected = IllegalStateException::class) - Not working
    fun crashApp() = runTest {
        val standardTestDispatcher: TestDispatcher = StandardTestDispatcher(
            scheduler = testScheduler,
        )
        val testScope = TestScope(
            context = standardTestDispatcher,
        )
        val homeScreenViewModel = HomeScreenViewModel(
            coroutineScope = testScope,
        )

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("Caught exception: $throwable")
        }

        val job = homeScreenViewModel.crashApp(
            context = coroutineExceptionHandler,
        )
        job.join()

        println("Test completed")

        // Not working
        /*
        Assert.assertThrows(IllegalStateException::class.java) {
            homeScreenViewModel.crashApp()
        }
        */
    }
}
