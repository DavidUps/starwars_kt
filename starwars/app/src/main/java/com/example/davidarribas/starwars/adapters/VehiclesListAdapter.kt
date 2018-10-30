package com.example.davidarribas.starwars.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Vehicles
import kotlinx.android.synthetic.main.films_list_adapter.view.*

class VehiclesListAdapter(private val vehicles : ArrayList<Vehicles>, val context: Context, private val clickListener: (Vehicles) -> Unit): RecyclerView.Adapter<VehiclesListAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflate = LayoutInflater.from(p0.context).inflate(R.layout.films_list_adapter, p0, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    override fun onBindViewHolder(p0: VehiclesListAdapter.ViewHolder, p1: Int) {
        p0.bindItems(vehicles[p1], clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(vehicles: Vehicles, clickListener: (Vehicles) -> Unit){
            itemView.tvTitle.text = vehicles.name
            itemView.setOnClickListener {clickListener(vehicles)}
        }
    }
}