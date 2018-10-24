package com.example.davidarribas.starwars.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.*

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

    fun openStarships(starship: Starship){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, StarshipFragment.newInstance(starship)).addToBackStack("openStarships").commit()
    }

    fun openPlanetList(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, PlanetsListFragment()).addToBackStack("openPlanet").commit()
    }

    fun openSpecieList(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SpeciesListFragment()).addToBackStack("openSpecieList").commit()
    }

    fun openSpecie(species: Species) {
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, SpecieFragment.newInstance(species)).addToBackStack("openSpecie").commit()
    }

    fun openStarshipsList(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, StarshipsListFragment()).addToBackStack("openStarshipsList").commit()

    }

    fun openVehicles(){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, VehiclesListFragment()).addToBackStack("openVehicles").commit()
    }

    fun openFilmFramgent(film : Film){
        supportFragmentManager.beginTransaction().replace(R.id.lyMain, FilmFragment.newInstance(film)).addToBackStack("openFilmFramgent").commit()
    }
}
