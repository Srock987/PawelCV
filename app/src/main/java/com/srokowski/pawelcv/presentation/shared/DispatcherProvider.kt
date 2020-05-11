package com.srokowski.pawelcv.presentation.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

open class DispatcherProvider(val main : CoroutineDispatcher = Dispatchers.Main, val io : CoroutineDispatcher = Dispatchers.IO)
