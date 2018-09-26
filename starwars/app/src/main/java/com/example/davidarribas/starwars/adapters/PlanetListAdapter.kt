package com.example.davidarribas.starwars.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Planet
import kotlinx.android.synthetic.main.films_list_adapter.view.*

class PlanetListAdapter (val planet: ArrayList<Planet>, val context: Context, val clickListener: (Planet) -> Unit): RecyclerView.Adapter<PlanetListAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflate = LayoutInflater.from(p0.context).inflate(R.layout.films_list_adapter, p0, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    override fun onBindViewHolder(p0: PlanetListAdapter.ViewHolder, p1: Int) {
        p0.bindItems(planet [p1],context,clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(planet: Planet, context: Context, clickListener: (Planet) -> Unit){
            itemView.tvTitle.setText(planet.name)
            itemView.setOnClickListener({clickListener(planet)})
        }
    }

}