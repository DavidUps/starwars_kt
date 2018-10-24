package com.example.davidarribas.starwars

import com.example.davidarribas.starwars.model.*
import retrofit2.Call
import retrofit2.http.*


interface StarwarsService {

    @GET("films/")
    fun getFilms(): Call<Films>

    @GET("people/")
    fun getPeople(@Query("page") page: Int): Call<PersonList>

    @GET("planets/")
    fun getPlanets(@Query("page") page: Int): Call<PlanetList>

    @GET("species/")
    fun getSpecies(@Query("page") page: Int): Call<SpeciesList>

    @GET("starships/")
    fun getStarships(@Query("page") page: Int): Call<StarshipList>

}