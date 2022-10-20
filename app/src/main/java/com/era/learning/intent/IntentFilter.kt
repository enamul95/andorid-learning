package com.era.learning.intent

import android.app.Notification
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.era.learning.R

class IntentFilter : AppCompatActivity() {

    private  lateinit var btnSent:Button
    private  lateinit var btnView:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_filter)

        btnSent = findViewById(R.id.btnSent)
        btnView = findViewById(R.id.btnView)

        btnSent.setOnClickListener {

            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "enamul@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject : This is a dummy message ")
            intent.putExtra(Intent.EXTRA_TEXT, "Hi This is Enamul Good Morning..")
            startActivity(intent)
        }

        btnView.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            startActivity(intent)
        }


    }
}