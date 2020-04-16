package com.sunshine.domain.base

import kotlinx.coroutines.CoroutineDispatcher


interface AppCoroutineDispatcher {
    val dispatcher: CoroutineDispatcher
}