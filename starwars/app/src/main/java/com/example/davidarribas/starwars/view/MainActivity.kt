package com.example.davidarribas.starwars.view

import android.app.PendingIntent.getActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.davidarribas.starwars.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SelectionFragment()).addToBackStack("Setting").commit()
    }

    fun openFilms(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, FilmsFragment()).addToBackStack("Setting").commit()
    }

    fun openPeople(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PeopleFragment()).addToBackStack("Setting").commit()

    }

    fun openPlanet(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PlanetsFragment()).addToBackStack("Setting").commit()

    }

    fun openSpecie() {
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SpeciesFragment()).addToBackStack("Setting").commit()
    }

    fun openStarships(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, StarshipsFragment()).addToBackStack("Setting").commit()
    }

    fun openVehicles(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, VehiclesFragment()).addToBackStack("Setting").commit()
    }
}
