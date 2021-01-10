package com.example.kidya_example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData

class DrawerMessageBackAdapter : RecyclerView.Adapter<DrawerMessageBackAdapter.ViewHolder>() {
    val list = MockData.getMessageDrawerList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time = itemView.findViewById<TextView>(R.id.textTimeDrawer)
        val comment = itemView.findViewById<TextView>(R.id.textCommentDrawer)

        fun bind(item: MockData.MessageDrawer) {
            val d = item
        //    shop.text = d.shopName
            time.text=d.time
            comment.text = d.message

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}