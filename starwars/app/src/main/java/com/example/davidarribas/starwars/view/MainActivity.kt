package com.example.davidarribas.starwars.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.davidarribas.starwars.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SelectionListFragment()).addToBackStack("Setting").commit()
    }

    fun openFilms(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, FilmsListFragment()).addToBackStack("Setting").commit()
    }

    fun openPeople(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PeopleListFragment()).addToBackStack("Setting").commit()

    }

    fun openPlanet(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PlanetsListFragment()).addToBackStack("Setting").commit()

    }

    fun openSpecie() {
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SpeciesListFragment()).addToBackStack("Setting").commit()
    }

    fun openStarships(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, StarshipsListFragment()).addToBackStack("Setting").commit()
    }

    fun openVehicles(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, VehiclesListFragment()).addToBackStack("Setting").commit()
    }
}
