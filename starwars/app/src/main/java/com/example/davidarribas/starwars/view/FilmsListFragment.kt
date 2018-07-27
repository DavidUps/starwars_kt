package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.StarwarsService
import com.example.davidarribas.starwars.adapters.FilmListAdapter
import com.example.davidarribas.starwars.model.Film
import com.example.davidarribas.starwars.model.Films
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilmsListFragment: Fragment() {

    private val BASE_URL = "https://swapi.co/api/"
    private val filmList: ArrayList<Film> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadFilms()
    }

    private fun loadFilms(){
        val builderFilm = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        val film = builderFilm.build()

        val starWarsClient = film.create(StarwarsService::class.java!!)
        val call = starWarsClient.getFilms()

        call.enqueue(object : Callback<Films> {
            override fun onResponse(call: Call<Films>, response: Response<Films>) {
                val film = response.body()
                for (i in 0..film!!.count - 1){
                    filmList.add(Film(film.results[i].title, film.results[i].episode_id, film.results[i].opening_crawl,
                            film.results[i].director, film.results[i].producer, film.results[i].release_date, film.results[i].characters,
                            film.results[i].planets, film.results[i].vehicles, film.results[i].species, film.results[i].created,
                            film.results[i].edited, film.results[i].url))
                }

                rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                rvList.adapter = FilmListAdapter(filmList, view!!.context, {item : Film -> filmClicked(item)})
            }

            override fun onFailure(call: Call<Films>, t: Throwable) {
                Toast.makeText(activity, "" + call + "" + t, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun filmClicked(film: Film){
        (activity as MainActivity).openFilmFramgent(film)
    }
}