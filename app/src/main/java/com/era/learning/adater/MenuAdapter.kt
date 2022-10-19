package com.era.learning.adater


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.era.learning.R
import com.era.learning.`interface-service`.OnMenuItemClickListener
import com.era.learning.model.MenuModel



class MenuAdapter(var list:ArrayList<MenuModel>,var listener:OnMenuItemClickListener): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_menu, parent, false)

        return ViewHolder(inflater)

    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {

        //Get element from  dataset at this position and replace the
        // contents of the view with that element
        val menu = list[position]
       // Log.e("desc-->",menu.desc.toString())
        holder.tvMenuName.setText(menu.desc)
        holder.itemView.setOnClickListener {
            listener.onMenuItemClick(menu)


        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return  list.size
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvMenuName: TextView

        init {
            // Define click listener for the ViewHolder's View.
            tvMenuName = view.findViewById(R.id.tvMenuName)
        }
    }

}