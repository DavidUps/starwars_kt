package com.example.davidarribas.starwars.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Film
import com.example.davidarribas.starwars.model.Person

class PersonListAdapter (val people: ArrayList<Person>, val context: Context, val clickListener: (Person -> Unit): RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PersonListAdapter.ViewHolder{
        val inflate = LayoutInflater.from(p0.context).inflate(R.layout.films_list_adapter, p0, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(p0:, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}