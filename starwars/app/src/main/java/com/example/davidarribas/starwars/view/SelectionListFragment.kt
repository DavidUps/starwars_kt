package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.ImagesUrl
import com.squareup.picasso.Picasso
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

        loadImages()
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

    private fun loadImages(){
        Picasso.get().load(ImagesUrl.selectionFilm).into(ivFilm)
        Picasso.get().load(ImagesUrl.selectionPeople).into(ivPeople)
        Picasso.get().load(ImagesUrl.selectionPlanet).into(ivPlanet)
        Picasso.get().load(ImagesUrl.selectionSpecie).into(ivSpecie)
        Picasso.get().load(ImagesUrl.selectionStarship).into(ivStarship)
        Picasso.get().load(ImagesUrl.selectionVehicle).into(ivVehicle)
    }
}