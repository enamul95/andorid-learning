package com.era.learning.view.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.era.learning.R

open class ServiceActivity : AppCompatActivity() {

    private lateinit var btnStartServiceBackground:Button
    private lateinit var btnStop:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnStartServiceBackground = findViewById(R.id.btnStartServiceBackground)
        btnStop = findViewById(R.id.btnStop)

        btnStartServiceBackground.setOnClickListener {
            val intent = Intent(applicationContext,MyService::class.java)
            startService(intent)
        }

        btnStop.setOnClickListener {
            val intent = Intent(applicationContext,MyService::class.java)
            stopService(intent)
        }

    }

}