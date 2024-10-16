package com.makeappssimple.abhimanyu.coroutinesplayground.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
public class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
