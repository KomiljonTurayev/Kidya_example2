package com.example.kidya_example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_home_news.view.*
import kotlinx.android.synthetic.main.item_news_back_list.view.*
import kotlinx.android.synthetic.main.item_news_back_list.view.imageDressNovosti

class NewsBackAdapter :
    RecyclerView.Adapter<NewsBackAdapter.ViewHolder>() {

    var list = MockData.getNovostiList()

    //        var onItemClick:((MockData.SkitkaModel)->Unit)?=null
    var onItemClick: ((MockData.NovostiModel) -> Unit)? = null

//    var data =  listOf<MockData.get>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.imageDressNovosti
        val aboutSHop = view.textMarketName
        val time = view.textTime

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
                view.findNavController().navigate(R.id.nav_news_back)
            }
        }

        fun bind(category: MockData.NovostiModel) {
            itemView.apply {
                img.setImageResource(category.image)
                aboutSHop.text = category.aboutDress
                time.text = category.date

//                imageKategory.setOnClickListener {
//                    Toast.makeText(itemView.context, "$position", Toast.LENGTH_SHORT).show()
//
//                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_news_back_list, parent, false)
        return   ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size ?: 0

}