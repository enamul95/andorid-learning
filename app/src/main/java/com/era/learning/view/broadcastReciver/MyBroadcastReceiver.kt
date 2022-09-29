package com.era.learning.view.broadcastReciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.lang.StringBuilder

class MyBroadcastReceiver : BroadcastReceiver() {

    private  val TAG = "MyBroadcastReceiver"

    override fun onReceive(context: Context, intent: Intent) {


        val  isAirplanMode = intent.getBooleanExtra("state",false)?:return

        if (isAirplanMode){
            Toast.makeText(context, "Aire Plane Mode is Enable.", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Aire Plane Mode is disable.", Toast.LENGTH_LONG).show()
        }
/*
        StringBuilder().apply {
            append("Action: ${intent.action} \n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)} \n")
                .toString().also { logs->
                    Log.e(TAG, logs)
                    Toast.makeText(context, logs, Toast.LENGTH_LONG).show()

                }
        }
        */

    }


}