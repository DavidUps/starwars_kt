package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_selection, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        film.setOnClickListener {
            openFilms()
        }

        people.setOnClickListener {
            openPeople()
        }

        planet.setOnClickListener {
            openPlanet()
        }

        specie.setOnClickListener {
            openSpecie()
        }

        starship.setOnClickListener {
            openStarships()
        }

        vehicle.setOnClickListener {
            openVehicles()
        }
    }

    private fun openFilms(){
    }

    private fun openPeople(){

    }

    private fun openPlanet(){

    }

    private fun openSpecie() {

    }

    private fun openStarships(){

    }

    private fun openVehicles(){

    }
}