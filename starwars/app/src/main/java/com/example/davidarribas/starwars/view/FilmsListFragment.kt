package com.example.davidarribas.starwars.view

import android.graphics.drawable.AnimationDrawable
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

    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFilms()
    }

    private fun loadFilms(){

        clProgressBar.visibility = View.VISIBLE
        ivProgressBar.setBackgroundResource(R.drawable.load_progressbar)
        animationDrawable = ivProgressBar.background as AnimationDrawable
        animationDrawable.start()

        getFilms(object : Load{
            override fun onLoad() {
                clProgressBar.visibility = View.GONE
            }

            override fun onErrorLoad() {
                clProgressBar.visibility = View.GONE
                Toast.makeText(activity, getString(R.string.list_error), Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun getFilms(loadlist: Load) {

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

                if (rvList != null){
                    rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                    rvList.adapter = FilmListAdapter(filmList, view!!.context, {item : Film -> filmClicked(item)})
                }

                if (filmList.isEmpty()){
                    loadlist.onErrorLoad()
                }else{
                    loadlist.onLoad()
                }
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