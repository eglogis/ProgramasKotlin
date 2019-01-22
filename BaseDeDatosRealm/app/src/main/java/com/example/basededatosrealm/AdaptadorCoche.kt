package com.example.basededatosrealm

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_coche.view.*


class AdaptadorCoche (private var items: List<CarModel>, private val listener: (CarModel) -> Unit) : RecyclerView.Adapter<AdaptadorCoche.CarViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CarViewHolder {

        return CarViewHolder(
            LayoutInflater.from(p0.context).inflate(
            R.layout.row_coche, p0, false))
    }

    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(p0: CarViewHolder, p1: Int) {

        val car = items.get(p1) //- También se puede usar items[position]
        p0.brandLabel.text = car.brand
        p0.itemView.setOnClickListener {

            listener(car)
        }
    }


    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val brandLabel = itemView.carRowBrandLabel
    }
}