package com.dkarmazi.viewmodelscoping

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Copyright (c) 2018 Pandora Media, Inc.
 */
class HeadlessFragment: Fragment() {
    companion object {
        private const val TAG = "HeadlessFragment"
        
        fun getInstance(): Fragment {
            return HeadlessFragment() 
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "HeadlessFragment ${hashCode()}, onCreate")

        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tv = TextView(context)
        tv.text = "HeadLessFragment"
        return tv
    }

    override fun onDestroy() {
        Log.d(TAG, "HeadlessFragment ${hashCode()}, onDestroy")
        
        super.onDestroy()
    }
}
