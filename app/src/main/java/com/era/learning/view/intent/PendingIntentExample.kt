package com.era.learning.view.intent

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.era.learning.R

class PendingIntentExample : AppCompatActivity() {

    private lateinit var btnCreateNotification:Button
    private lateinit var btnCancelNotificaton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_intent)

        btnCreateNotification = findViewById(R.id.btnCreateNotification)
        btnCancelNotificaton = findViewById(R.id.btnCancelNotificaton)

        btnCreateNotification.setOnClickListener {
            createNotification()

        }


        btnCancelNotificaton.setOnClickListener {
            val ns: String = Context.NOTIFICATION_SERVICE
            val nMgr = applicationContext.getSystemService(ns) as NotificationManager
            nMgr.cancel(1)
        }


    }

    fun createNotification() {

        Log.e("createNotification--","--createNotification")
     var builder = NotificationCompat.Builder(this)
         .setSmallIcon(R.drawable.alert)

        var intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/"))
        //val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        builder.setContentIntent(pendingIntent)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher))
        builder.setContentTitle("Notification Titile")
        builder.setContentText("Here is the content of the body of notificaiton************Test")
        builder.setSubText("Tap to view the website.....")


        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Will display the notification in the notification bar

        notificationManager.notify(1,builder.build())
        Log.e("createNotification--","--notificationManager")

    }
}