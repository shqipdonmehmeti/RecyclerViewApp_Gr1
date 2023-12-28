package com.example.recyclerviewapp_gr1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp_gr1.R
import com.example.recyclerviewapp_gr1.models.User

class UserAdapter(private val userList : List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvName.text = user.name
        holder.tvStreet.text = user.address.street
        holder.tvGeoLat.text = user.address.geo.lat
        holder.tvGeoLng.text = user.address.geo.lng
    }

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvName : TextView = itemView.findViewById(R.id.tvName)
        val tvStreet : TextView = itemView.findViewById(R.id.tvStreet)
        val tvGeoLat : TextView = itemView.findViewById(R.id.tvGeoLat)
        val tvGeoLng : TextView = itemView.findViewById(R.id.tvGeoLng)
    }
}