package com.example.kidya_example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_grid.view.*

class GridAdapter : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    val list = MockData.getGridList()
//    var onItemClick: ((MockData.NovostiModel) -> Unit)? = null

    var onItemClick:((MockData.Grid)->Unit)?=null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.imageGrig
        val text = view.textGridName

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(list[adapterPosition])
            }
        }

        fun bind(grid: MockData.Grid) {
            itemView.apply {
                img.setImageResource(grid.image)
                text.text = grid.text

                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "$position", Toast.LENGTH_SHORT).show()
                    itemView.findNavController().navigate(R.id.nav_kategory_back)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size ?: 0
}