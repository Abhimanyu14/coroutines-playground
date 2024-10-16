package com.makeappssimple.abhimanyu.coroutinesplayground.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makeappssimple.abhimanyu.coroutinesplayground.android.di.ApplicationScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
public class HomeScreenViewModel @Inject constructor(
    @ApplicationScope coroutineScope: CoroutineScope,
) : ViewModel(
    viewModelScope = coroutineScope,
) {
    public fun crashApp(
        context: CoroutineContext = EmptyCoroutineContext,
    ): Job {
        return viewModelScope.launch(context) {
            println("Throwing exception")
            throw IllegalStateException("Crash App Test")
        }
    }
}
