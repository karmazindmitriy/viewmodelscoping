package com.dkarmazi.viewmodelscoping

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class VmFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MyViewModel::class.java) {
            return MyViewModel() as T
        } else {
            throw IllegalArgumentException()
        }
    }
}