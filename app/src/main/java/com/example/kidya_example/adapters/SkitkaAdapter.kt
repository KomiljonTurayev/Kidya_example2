package com.example.kidya_example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_favourite.view.*

class SkitkaAdapter(val wish: Boolean = false) :
    RecyclerView.Adapter<SkitkaAdapter.ViewHolder>() {

    var onItemClick: ((MockData.SkitkaModel) -> Unit)? = null
    val list = MockData.getSkitkaList()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wishs = view.text_wish
        val news = view.image_heart

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
//                view.findNavController().navigate(R.id.nav_skitka_back)
//                view.findNavController().navigate(R.id.nav_news_back)
            }

            news.setOnClickListener {
                Toast.makeText(itemView.context, "fav clickes", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(skitka: MockData.SkitkaModel) {
            itemView.apply {
                textNarx.text = skitka.money
                textDress.text = skitka.dressName
                textShopDrawer.text = skitka.shopName
                imageDress.setImageResource(skitka.image)

                if (wish) {
                    wishs.visibility = View.GONE
                    news.visibility = View.GONE

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkitkaAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favourite, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkitkaAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


}