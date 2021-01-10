package com.example.kidya_example.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_bell.view.*

class BellAdapter : RecyclerView.Adapter<BellAdapter.ViewHolder>() {
    val list = MockData.getBellList()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textTitle = itemView.textViewTitle
        val textDate = itemView.textViewDate
        val textInf = itemView.textViewInfo
        val imageBellMore = itemView.imageBellMore

        // The gesture threshold expressed in dp
        private  val GESTURE_THRESHOLD_DP = 16.0f

        private var mGestureThreshold: Int = 0

        init {

            mGestureThreshold = (52 *( GESTURE_THRESHOLD_DP / 160f)).toInt()

            var i = 0
            imageBellMore.setOnClickListener {
                Toast.makeText(itemView.context, "imageBellMore", Toast.LENGTH_SHORT).show()
//                textInf.width = ViewGroup.LayoutParams.MATCH_PARENT
//                textInf.height = ViewGroup.LayoutParams.WRAP_CONTENT
                i = (i + 1) % 2
                if (i == 1) {
                    val params: ViewGroup.LayoutParams =
                        textInf.layoutParams as ViewGroup.LayoutParams
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT
                    textInf.setLayoutParams(params)
                } else {
                    val params: ViewGroup.LayoutParams =
                        textInf.layoutParams as ViewGroup.LayoutParams
                    params.height = pxFromDp(52f)
                    textInf.setLayoutParams(params)
                    i = 0
                }
            }
        }


        fun pxFromDp(dp: Float): Int {
            return Math.round(dp * Resources.getSystem().getDisplayMetrics().density).toInt()
        }


        fun bind(item: MockData.BellData) {
            itemView.apply {
                val d = item
                textTitle.text = d.aksiya
                textDate.text = d.date
                textInf.text = d.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bell, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size
}