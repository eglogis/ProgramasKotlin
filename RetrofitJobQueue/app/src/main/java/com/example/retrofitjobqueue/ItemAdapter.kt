package com.example.retrofitjobqueue

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_item.view.*

class ItemAdapter(private val items: List<ModeloItem>, private val listener: (ModeloItem) -> Unit): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {

        return ItemViewHolder(
            LayoutInflater.from(p0.context).inflate(
            R.layout.row_item, p0, false))

    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {

        val item = items.get(p1) //- También se puede usar items[position]
        p0.itemId.text = item.phone1
        p0.itemName.text = item.category
        p0.itemView.setOnClickListener {
            listener(item)

        }
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemId = itemView.rowItemId
        val itemName = itemView.rowItemName
    }
}