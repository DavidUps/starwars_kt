package com.example.davidarribas.starwars

import com.example.davidarribas.starwars.model.Films
import com.example.davidarribas.starwars.model.PersonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface StarwarsService {

    @GET("films/")
    fun getFilms(): Call<Films>

    @GET("{num}")
    fun getPeople(@Path("num") num: String): Call<PersonList>


}