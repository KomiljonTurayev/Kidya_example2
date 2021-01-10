package com.example.kidya_example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_home_category.view.*

class KategoryAdapter() :
    RecyclerView.Adapter<KategoryAdapter.ViewHolder>() {

    var list = MockData.getCatList()

    //        var onItemClick:((MockData.SkitkaModel)->Unit)?=null
    var onItemClick: ((MockData.Category) -> Unit)? = null

//    var data =  listOf<MockData.get>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.imageKategory

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }

        }

        fun bind(category: MockData.Category) {
            itemView.apply {
                img.setImageResource(category.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list!![position])

    override fun getItemCount() = list.size ?: 0

}