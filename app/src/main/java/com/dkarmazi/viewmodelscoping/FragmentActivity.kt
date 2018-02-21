package com.dkarmazi.viewmodelscoping

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class FragmentActivity: AppCompatActivity() {
    companion object {
        private const val TAG = "FragmentActivity"
        private const val KEY = "key_key"
        private const val FRAGMENT_TAG = "fragment_tag"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d(TAG, "Activity ${hashCode()}, onCreate: orientation ${resources.configuration.orientation} Thread: ${Thread.currentThread().hashCode()}")
        
        if (savedInstanceState != null) {
            Log.d(TAG, "Activity ${hashCode()}, onCreate: saved string from savedInstanceState ${savedInstanceState.getString(KEY)}")
        } else {
            Log.d(TAG, "Activity ${hashCode()}, onCreate: no savedInstanceState")
        }

        val myViewModel: MyViewModel = ViewModelProviders
                .of(this, VmFactory())
                .get(MyViewModel::class.java)

        var hf = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)

        if (hf == null) {
            hf = HeadlessFragment.getInstance()
            supportFragmentManager.beginTransaction().add(hf, FRAGMENT_TAG).commit()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity ${hashCode()}, onResume: orientation ${resources.configuration.orientation}")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity ${hashCode()}, onStop: orientation ${resources.configuration.orientation}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity ${hashCode()}, onDestroy: orientation=${resources.configuration.orientation} isFinishing=$isFinishing isChangingConfigurations=$isChangingConfigurations")
    }
    
    override fun onSaveInstanceState(outState: Bundle?) {
        val savedString = "SAVED_STATE_" + hashCode()
        outState?.putString(KEY, savedString)
        Log.d(TAG, "Activity ${hashCode()}, onSaveInstanceState: $savedString")

        super.onSaveInstanceState(outState)
    }
}
