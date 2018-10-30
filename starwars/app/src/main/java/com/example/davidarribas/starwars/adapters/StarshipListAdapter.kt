package com.example.davidarribas.starwars.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Starships
import kotlinx.android.synthetic.main.films_list_adapter.view.*

class StarshipListAdapter(val starship : ArrayList<Starships>, val context: Context, private val clickListener: (Starships) -> Unit): RecyclerView.Adapter<StarshipListAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflate = LayoutInflater.from(p0.context).inflate(R.layout.films_list_adapter, p0, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return starship.size
    }

    override fun onBindViewHolder(p0: StarshipListAdapter.ViewHolder, p1: Int) {
        p0.bindItems(starship [p1], clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(starship: Starships, clickListener: (Starships) -> Unit){
            itemView.tvTitle.text = starship.name
            itemView.setOnClickListener {clickListener(starship)}
        }
    }
}