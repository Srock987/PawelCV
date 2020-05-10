package com.srokowski.pawelcv.presentation.shared

interface Binder<T> {
    fun onBind(data: T)
}