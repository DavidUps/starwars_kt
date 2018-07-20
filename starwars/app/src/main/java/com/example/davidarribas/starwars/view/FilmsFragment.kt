package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.StarwarsService
import com.example.davidarribas.starwars.model.Films
import kotlinx.android.synthetic.main.fragment_films.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilmsFragment: Fragment() {

    private val BASE_URL = "https://swapi.co/api/"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_films, container, false)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadFilms()
    }

    private fun loadFilms(){
        val builderPerson = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        val person = builderPerson.build()

        val starWarsClient = person.create(StarwarsService::class.java!!)
        val call = starWarsClient.getFilms()

        call.enqueue(object : Callback<Films> {
            override fun onResponse(call: Call<Films>, response: Response<Films>) {
                val film = response.body()

                tvFilmUno.setText(film!!.results[0].title)
                tvFilmDos.setText(film!!.results[1].title)
                tvFilmTres.setText(film!!.results[2].title)
                tvFilmCuatro.setText(film!!.results[3].title)
                tvFilmCinco.setText(film!!.results[4].title)
                tvFilmSeis.setText(film!!.results[5].title)
                tvFilmSiete.setText(film!!.results[6].title)

            }

            override fun onFailure(call: Call<Films>, t: Throwable) {
                Toast.makeText(activity, "" + call + "" + t, Toast.LENGTH_LONG).show()
            }
        })
    }
}