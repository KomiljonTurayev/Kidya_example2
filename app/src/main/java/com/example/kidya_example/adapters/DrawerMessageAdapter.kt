package com.example.kidya_example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData

class DrawerMessageAdapter : RecyclerView.Adapter<DrawerMessageAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shop = itemView.findViewById<TextView>(R.id.textShopDrawer)
        val time = itemView.findViewById<TextView>(R.id.textTimeDrawer)
        val comment = itemView.findViewById<TextView>(R.id.textCommentDrawer)
//        val frameLayoutMessage = itemView.findViewById<View>(R.id.frameLayoutMessage)

        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "${it.id}", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(item: MockData.MessageDrawer) {
            val d = item
            shop.text = d.shopName
            time.text = d.time
            comment.text = d.message

        }
    }
    val list = MockData.getMessageDrawerList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}