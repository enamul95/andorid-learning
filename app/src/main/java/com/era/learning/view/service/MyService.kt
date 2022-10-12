package com.era.learning.view.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    private lateinit var  mediaPlayer:MediaPlayer


    override fun onCreate() {
      //  mediaPlayer = MediaPlayer.create(this,R.raw.)
        //super.onCreate()
    }
    override fun onBind(intent: Intent?): IBinder? {
      throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)

        Toast.makeText(applicationContext, "This is a Service running in Background",Toast.LENGTH_SHORT).show()
        return START_STICKY
      //  return super.onStartCommand(intent, flags, startId)
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        val restartServiceIntent = Intent(applicationContext, this.javaClass)
        restartServiceIntent.setPackage(packageName)
        startService(restartServiceIntent)
        super.onTaskRemoved(rootIntent)
        //super.onTaskRemoved(rootIntent)
    }
}