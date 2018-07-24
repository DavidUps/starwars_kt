package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionListFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_selection, container, false)

        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private fun openFilms(){
        (activity as MainActivity).openFilms()
    }

    private fun openPeople(){
        (activity as MainActivity).openPeople()
    }

    private fun openPlanet(){
        (activity as MainActivity).openPlanet()
    }

    private fun openSpecie(){
        (activity as MainActivity).openSpecie()
    }

    private fun openStarships(){
        (activity as MainActivity).openStarships()
    }

    private fun openVehicles(){
        (activity as MainActivity).openVehicles()
    }

}