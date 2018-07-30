package com.example.davidarribas.starwars.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Film
import com.example.davidarribas.starwars.model.Films
import kotlinx.android.synthetic.main.films_list_adapter.view.*
import java.text.FieldPosition

class FilmListAdapter (var films: ArrayList<Film>, val context: Context, val clickListener: (Film) -> Unit): RecyclerView.Adapter<FilmListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListAdapter.ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.films_list_adapter, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(holder: FilmListAdapter.ViewHolder, position: Int) {
        holder.bindItems(films[position],context,clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(film: Film, context: Context, clickListener: (Film) -> Unit){
            itemView.tvTitle.setText(film.title)
            itemView.setOnClickListener { clickListener(film) }
        }
    }


}