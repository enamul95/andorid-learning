package com.era.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.era.learning.`interface-service`.OnMenuItemClickListener
import com.era.learning.adater.MenuAdapter
import com.era.learning.intent.IntentFilter
import com.era.learning.model.MenuModel
import com.era.learning.view.broadcastReciver.BroadCastReciverAirPlanModeChange
import com.era.learning.view.broadcastReciver.BroardCastReceiverImageRecive
import com.era.learning.view.content_provider.ContentProviderActivity
import com.era.learning.view.intent.PendingIntentExample
import com.era.learning.view.service.ServiceActivity

class MainActivity : AppCompatActivity(), OnMenuItemClickListener {

    private lateinit var rcycleView: RecyclerView

    val menuList = ArrayList<MenuModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcycleView = findViewById(R.id.rcycleView)


        populateMenuList();


    }


    private fun populateMenuList() {
        menuList.clear()
        menuList.add(MenuModel("Board Cast Receiver", "BCR"))
        menuList.add(MenuModel("Board Cast AireMode", "BCA"))
        menuList.add(MenuModel("Pending Intent", "PI"))
        menuList.add(MenuModel("Service", "SERVICE"))
        menuList.add(MenuModel("Content Provider", "CP"))
        menuList.add(MenuModel("Intent Filter", "IF"))


        val menuAdapter = MenuAdapter(menuList, this)
        rcycleView.layoutManager = LinearLayoutManager(rcycleView.context)
        rcycleView.adapter = menuAdapter
    }

    //Interface implementation
    override fun onMenuItemClick(item: MenuModel) {

        if ("BCR" == item.code) {
            val intent = Intent(this, BroardCastReceiverImageRecive::class.java)
            startActivity(intent)
        }

        if ("BCA" == item.code) {
            val intent = Intent(this, BroadCastReciverAirPlanModeChange::class.java)
            startActivity(intent)
        }

        if ("PI" == item.code) {
            val intent = Intent(this, PendingIntentExample::class.java)
            startActivity(intent)
        }
        if ("SERVICE" == item.code) {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }

        if ("CP" == item.code) {
            val intent = Intent(this, ContentProviderActivity::class.java)
            startActivity(intent)
        }

        if ("IF" == item.code) {
            val intent = Intent(this, IntentFilter::class.java)
            startActivity(intent)
        }


    }

}