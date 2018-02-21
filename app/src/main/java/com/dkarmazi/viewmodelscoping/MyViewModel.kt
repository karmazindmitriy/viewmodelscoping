package com.dkarmazi.viewmodelscoping

import android.arch.lifecycle.ViewModel
import android.util.Log

class MyViewModel: ViewModel() {
    companion object {
        private const val TAG = "MyViewModel"
    }
    
    init {
        Log.d(TAG, "MyViewModel: created: " + hashCode())
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(TAG, "MyViewModel: onCleared: " + hashCode())
    }
}
