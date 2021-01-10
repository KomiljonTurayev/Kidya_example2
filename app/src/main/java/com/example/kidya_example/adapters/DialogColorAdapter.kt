package com.example.kidya_example.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_color.view.*

class DialogColorAdapter(
) : RecyclerView.Adapter<DialogColorAdapter.ViewHolder>() {

    val list = MockData.getColorList()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image = itemView.imgOne
        var image2 = itemView.imgTwo

        //
        var i = 0

        init {
//            if (check) {

            itemView.setOnClickListener {
                Log.d("ttt", " itemView.setOnClickListener   ")

                i = (i + 1) % 2
                if (i == 1) {
                    image2.visibility = View.INVISIBLE
                } else {
                    image2.visibility = View.VISIBLE
                    i = 0

                }
            }
        }

        fun bind(item: MockData.ItemDialog) {
            itemView.apply {
                val d = item

                image?.backgroundTintList = ColorStateList.valueOf(Color.parseColor(d.item2))
                image2?.backgroundTintList = ColorStateList.valueOf(Color.parseColor(d.item2))
                Log.d("ttt", "${item}")

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size
}