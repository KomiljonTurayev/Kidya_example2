package com.example.kidya_example.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_news_back_list.view.*
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAdapter(): RecyclerView.Adapter<OrderAdapter.Itemview>() {

    val list=MockData.getOrderDataList()
//    val listNew=Datasource.orderItemDynamic()

//     var onItemClick: ((MockData.NovostiModel) -> Unit)? = null
    var onItemClick:((MockData.OrderData)->Unit)?=null

    inner class Itemview(view: View): RecyclerView.ViewHolder(view){

        var orderContent = view.findViewById<LinearLayout>(R.id.orderContent)
//        val orderNum=view.order_number
//        val date=view.date_order
//        val price=view.price_order
//        val delliviry=view.price_delliviry
//        val overal=view.overall_price
        val viewButtonOne=view.viewCircle1
        val viewLineOne=view.view1
        val viewButtonTwo=view.viewCircle2
        val viewLineTwo=view.view2
        val viewButtonThree=view.viewCircle3
        val viewLineThree=view.view3
        val viewButtonFour=view.viewCircle4
        val viewLineFour=view.view4
        val viewButtonFive=view.viewCircle5

        val mainLayout=view.content
        // val layoutPar=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)

//        val itemsListLayout=view.itemsList
        //val textListLayout=view.textList

        init {

            orderContent.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
//                Toast.makeText(view.context, "orderContent", Toast.LENGTH_SHORT).show()
//                view.findNavController().navigate(R.id.nav_order_back)
            }
        }


        fun bind( d: MockData.OrderData){

//            orderNum.text="Заказ ${d.orderNumber}"
//            date.text=d.date
//            price.text=d.price
//            delliviry.text=d.delivery
//            overal.text=d.overall


            when(d.type){
                1->{viewButtonOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E"))) }
                2->{viewButtonOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonTwo.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))}
                3->{viewButtonOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonTwo.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineTwo.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonThree.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))}
                4->{viewButtonOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonTwo.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineTwo.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonThree.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineThree.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonFour.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                }
                5->{viewButtonOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineOne.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonTwo.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineTwo.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))


                    viewButtonThree.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineThree.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonFour.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewLineFour.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                    viewButtonFive.backgroundTintList=(ColorStateList.valueOf(Color.parseColor("#DE468E")))
                }
            }

            for(item in d.item) {
                val textViewShopName=TextView(itemView.context)
                val textviewTitle = TextView(itemView.context)
                val imageView=ImageView(itemView.context)
                val childLinearLayout=LinearLayout(itemView.context)
                childLinearLayout.layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                childLinearLayout.orientation = LinearLayout.HORIZONTAL

                val innerChild=LinearLayout(itemView.context)
                innerChild.layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                innerChild.orientation = LinearLayout.VERTICAL

                textviewTitle.textSize = 15f
                textViewShopName.textSize = 15f

                textviewTitle.text = item.product
                textViewShopName.text=item.shopName
                imageView.setImageResource(item.image)

                textviewTitle.setTypeface(null, Typeface.BOLD)
                textViewShopName.setTypeface(null, Typeface.BOLD)
                textviewTitle.setTextColor(Color.parseColor("#222C6B"))
                textViewShopName.setTextColor(Color.parseColor("#8D93B3"))

                textviewTitle.gravity = Gravity.CENTER_VERTICAL
                textViewShopName.gravity = Gravity.CENTER_VERTICAL

                imageView.setBackgroundResource(R.drawable.bg_shape)
                val layoutparamsfortextview = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                val layoutParmsImageView=LinearLayout.LayoutParams(120,120)

                val layoutParmsTextView=LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)

                imageView.setPadding(10,10,10,10)

                childLinearLayout.setPadding(10,10,10,10)

                layoutParmsImageView.gravity= Gravity.CENTER_VERTICAL
                layoutParmsTextView.gravity=Gravity.CENTER_VERTICAL

                layoutparamsfortextview.setMargins(20, 20, 20, 20)
//                layoutparamsfortextview.setMargins(16, 16, 16, 16)
                //    textview.layoutParams = layoutparamsfortextview

                textViewShopName.setPadding(16,8,16,0)
                textviewTitle.setPadding(16,16,16,0)

                textViewShopName.layoutParams=layoutParmsTextView
                textviewTitle.layoutParams=layoutParmsTextView

                imageView.layoutParams=layoutParmsImageView
//                innerChild.layoutParams=layoutParmsImageView
                // itemsListLayout.addView(textview)
                // itemsListLayout.addView(imageView)
                childLinearLayout.addView(imageView)
                childLinearLayout.addView(innerChild)

                innerChild.addView(textviewTitle)
                innerChild.addView(textViewShopName)
                mainLayout.addView(childLinearLayout)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Itemview {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return Itemview(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Itemview, position: Int) {
        return holder.bind(list[position])
    }
}