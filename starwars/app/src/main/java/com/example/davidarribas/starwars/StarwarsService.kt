package com.example.davidarribas.starwars

import com.example.davidarribas.starwars.model.Films
import com.example.davidarribas.starwars.model.Person
import com.example.davidarribas.starwars.model.PersonList
import retrofit2.Call
import retrofit2.http.GET

interface StarwarsService {

    @GET("films/")
    fun getFilms(): Call<Films>

    @GET("people/")
    fun getPeople(): Call<PersonList>
}