package com.example.kidya_example.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_client.view.*
import kotlinx.android.synthetic.main.item_seller.view.*

class MessageChattingAdapter : RecyclerView.Adapter<MessageChattingAdapter.BaseViewHolder>() {

    var list = MockData.getMessageChatList()

    private var listener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(f: (Int) -> Unit) {
        listener = f
    }

    override fun getItemViewType(position: Int) = when (list[position]) {
        is MockData.SellerData -> 0
        is MockData.ClientData -> 1
        else -> 0
    }

    inner class SellerDataViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(category: MockData.BaseData) {
            val d = list[adapterPosition] as MockData.SellerData
            itemView.apply {
                textName.text = d.name
                textNumber.text = d.number
                setOnClickListener { listener?.invoke(adapterPosition) }
            }
        }
    }

    inner class ClientDataViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(category: MockData.BaseData) {
            val d = list[adapterPosition] as MockData.ClientData
            itemView.apply {
                textNameClient.text = d.name
                textNumberClient.text = d.number
                setOnClickListener { listener?.invoke(adapterPosition) }
            }
        }
    }


    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(category: MockData.BaseData)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> SellerDataViewHolder(parent.inflate(R.layout.item_seller))
            1 -> ClientDataViewHolder(parent.inflate(R.layout.item_client))
            else ->  SellerDataViewHolder(parent.inflate(R.layout.item_seller))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size
}


fun ViewGroup.inflate(resId: Int) = LayoutInflater.from(context).inflate(resId, this, false)

fun String.showToast(context: Context) = Toast.makeText(context, this, Toast.LENGTH_SHORT).show()

