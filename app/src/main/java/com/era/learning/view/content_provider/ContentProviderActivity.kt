package com.era. learning.view.content_provider

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.era.learning.R

class ContentProviderActivity : AppCompatActivity() {

    private lateinit var btnReadContact:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        btnReadContact = findViewById(R.id.btnReadContact)

        btnReadContact.setOnClickListener {
            getContatcts()
        }


        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val READ_CONTACTS = ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_CONTACTS
                )

                val WRITE_CONTACTS = ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_CONTACTS
                )



                if (
                    READ_CONTACTS != PackageManager.PERMISSION_GRANTED
                    || WRITE_CONTACTS != PackageManager.PERMISSION_GRANTED

                ) {
                    ActivityCompat.requestPermissions(
                        this, arrayOf(
                            Manifest.permission.READ_CONTACTS,
                            Manifest.permission.WRITE_CONTACTS
                        ), 1
                    )
                }


            }


        } catch (ex: Exception) {
            ex.message?.let { Log.e("", it) }
        }
    }


    @SuppressLint("Range")
    private fun getContatcts(){
        val cr = contentResolver
        val  uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        var cursor = cr.query(uri,null,null,null,null);
        if(cursor != null){
            while (cursor.moveToNext()){
              var name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
              var phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                Log.e("name --",name)
                Log.e("phone --",phone)

            }

        }

    }
}