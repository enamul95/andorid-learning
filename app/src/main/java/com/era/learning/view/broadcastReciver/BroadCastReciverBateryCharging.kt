package com.era.learning.view.broadcastReciver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.era.learning.R

class BroadCastReciverBateryCharging : AppCompatActivity() {

    private  lateinit var myReceiver:MyBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batery_charging)

     //   val filter = IntentFilter()

        myReceiver = MyBroadcastReceiver()

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(myReceiver, filter)



    }

    override fun onPause() {
        unregisterReceiver(myReceiver);
        super.onPause()
    }

}