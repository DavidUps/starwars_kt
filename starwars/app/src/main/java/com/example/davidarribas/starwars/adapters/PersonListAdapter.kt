package com.example.davidarribas.starwars.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Person
import kotlinx.android.synthetic.main.films_list_adapter.view.*

class PersonListAdapter (val people: ArrayList<Person>, val context: Context, val clickListener: (Person) -> Unit): RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PersonListAdapter.ViewHolder{
        val inflate = LayoutInflater.from(p0.context).inflate(R.layout.films_list_adapter, p0, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(p0: PersonListAdapter.ViewHolder, p1: Int) {
        p0.bindItems(people [p1],context,clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(person: Person, context: Context,clickListener: (Person) -> Unit){
            itemView.tvTitle.setText(person.name)
        }
    }

}