package com.era.learning.view.broadcastReciver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.era.learning.R

class BroardCastReceiverImageRecive : AppCompatActivity() {

    private lateinit var ivReceiveImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_cast_receiver)

        /**
         * broadcast Receiver is some thing call back that generate by system
         * like alarm, battery low generate call back
         * Four broadcast: Normal Board cast
         * */

        /**
         *  * Four broadcast: Normal Board cast,ordered broadcast,sticky broadcast,
         *
         * */
        ivReceiveImage = findViewById(R.id.ivReceiveImage)

        val intent = intent
        val actions = intent.action
        val type = intent.type

        if(Intent.ACTION_SEND.equals(actions) && type != null){
            ivReceiveImage.setImageURI(intent.getParcelableExtra(Intent.EXTRA_STREAM))

        }



    }
}