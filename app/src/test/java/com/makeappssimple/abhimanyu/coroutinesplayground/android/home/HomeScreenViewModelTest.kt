package com.makeappssimple.abhimanyu.coroutinesplayground.android.home

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

internal class HomeScreenViewModelTest {
    // region SUT
    private lateinit var homeScreenViewModel: HomeScreenViewModel
    // endregion

    @Test // (expected = IllegalStateException::class) - Not working
    fun crashApp() = runTest {
        val standardTestDispatcher: TestDispatcher = StandardTestDispatcher(
            scheduler = testScheduler,
        )
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Assert.assertEquals(
                true,
                throwable is IllegalStateException,
            )
        }
        val testScope = TestScope(
            context = standardTestDispatcher + coroutineExceptionHandler,
        )
        homeScreenViewModel = HomeScreenViewModel(
            coroutineScope = testScope,
        )

        homeScreenViewModel.crashApp()

        // Not working
//        Assert.assertThrows(IllegalStateException::class.java) {
//            homeScreenViewModel.crashApp()
//        }
    }
}
