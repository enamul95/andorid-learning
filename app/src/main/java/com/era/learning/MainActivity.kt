package com.era.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.era.learning.`interface-service`.OnMenuItemClickListener
import com.era.learning.adater.MenuAdapter
import com.era.learning.model.MenuModel

class MainActivity : AppCompatActivity(), OnMenuItemClickListener {

    private lateinit var rcycleView:RecyclerView

    val menuList = ArrayList<MenuModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcycleView = findViewById(R.id.rcycleView)


        populateMenuList();


    }




    private fun populateMenuList(){
        menuList.clear()
        menuList.add(MenuModel("Board Cast Receiver","BCR"))
        menuList.add(MenuModel("Intent Filter","IF"))

        val menuAdapter = MenuAdapter(menuList,this)
        rcycleView.layoutManager = LinearLayoutManager(rcycleView.context)
        rcycleView.adapter = menuAdapter
    }

    //Interface implementation
    override fun onMenuItemClick(item: MenuModel) {
        Log.e("desc--",item.desc.toString())
        Log.e("code--",item.code.toString())
    }

}