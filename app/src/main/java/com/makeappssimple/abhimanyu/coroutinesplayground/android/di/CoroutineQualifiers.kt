package com.makeappssimple.abhimanyu.coroutinesplayground.android.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
public annotation class DefaultDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
public annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
public annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
public annotation class MainImmediateDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
public annotation class UnconfinedDispatcher
