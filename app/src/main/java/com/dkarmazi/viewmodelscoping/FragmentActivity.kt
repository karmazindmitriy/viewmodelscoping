package com.dkarmazi.viewmodelscoping

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class FragmentActivity: AppCompatActivity() {
    companion object {
        private const val TAG = "FragmentActivity"
        private const val KEY = "key_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d(TAG, "onCreate: " + hashCode() + " orientation: " + resources.configuration.orientation)

        if (savedInstanceState != null) {
            Log.d(TAG, "saved string from savedInstanceState: " + savedInstanceState.getString(KEY) + " " + hashCode())
        }

        val myViewModel: MyViewModel = ViewModelProviders
                .of(this, VmFactory())
                .get(MyViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume: " + hashCode() + " orientation: " + resources.configuration.orientation)
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop: " + hashCode() + " orientation: " + resources.configuration.orientation)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: " + hashCode() + " orientation: " + resources.configuration.orientation)
    }
    
    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(KEY, "SAVED_STATE")

        super.onSaveInstanceState(outState)
    }
}
