package com.example.davidarribas.starwars.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Film
import com.example.davidarribas.starwars.model.Person
import com.example.davidarribas.starwars.model.Planet

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SelectionListFragment()).addToBackStack("Setting").commit()
    }

    fun openFilms(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, FilmsListFragment()).addToBackStack("openFilm").commit()
    }

    fun openPeopleList(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PeopleListFragment()).addToBackStack("openPeopleList").commit()
    }

    fun openPeople(person : Person){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PeopleFragment.newInstance(person)).addToBackStack("openPeople").commit()
    }

    fun openPlanet(planet: Planet){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PlanetFragment.newInstance(planet)).addToBackStack("openPlanet").commit()
    }

    fun openPlanetList(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PlanetsListFragment()).addToBackStack("openPlanet").commit()
    }

    fun openSpecie() {
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SpeciesListFragment()).addToBackStack("openSpecie").commit()
    }

    fun openStarships(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, StarshipsListFragment()).addToBackStack("openStarships").commit()
    }

    fun openVehicles(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, VehiclesListFragment()).addToBackStack("openVehicles").commit()
    }

    fun openFilmFramgent(film : Film){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, FilmFragment.newInstance(film)).addToBackStack("openFilmFramgent").commit()
    }
}
