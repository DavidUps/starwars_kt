package com.example.davidarribas.starwars

import com.example.davidarribas.starwars.model.Films
import com.example.davidarribas.starwars.model.Person
import com.example.davidarribas.starwars.model.PersonList
import com.example.davidarribas.starwars.model.PlanetList
import retrofit2.Call
import retrofit2.http.*


interface StarwarsService {

    @GET("films/")
    fun getFilms(): Call<Films>

    @GET("people/")
    fun getPeople(@Query("page") page :Int): Call<PersonList>

    @GET("planets/")
    fun getPlanets(@Query("page") page: Int): Call<PlanetList>

}