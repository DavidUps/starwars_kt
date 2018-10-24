package com.example.davidarribas.starwars.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Species
import kotlinx.android.synthetic.main.films_list_adapter.view.*

class SpeciesListAdapter (val specie: ArrayList<Species>, val context: Context, val clickListener: (Species) -> Unit): RecyclerView.Adapter<SpeciesListAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflate = LayoutInflater.from(p0.context).inflate(R.layout.films_list_adapter, p0, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return specie.size
    }

    override fun onBindViewHolder(p0: SpeciesListAdapter.ViewHolder, p1: Int) {
        p0.bindItems(specie [p1],context,clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(specie: Species, context: Context, clickListener: (Species) -> Unit){
            itemView.tvTitle.setText(specie.name)
            itemView.setOnClickListener({clickListener(specie)})
        }
    }

}