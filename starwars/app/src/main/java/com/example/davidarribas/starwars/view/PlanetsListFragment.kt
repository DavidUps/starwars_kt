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
import com.example.davidarribas.starwars.adapters.PlanetListAdapter
import com.example.davidarribas.starwars.model.Planet
import com.example.davidarribas.starwars.model.PlanetList
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlanetsListFragment: Fragment() {

    private val BASE_URL = "https://swapi.co/api/"
    private var count = 1
    private var planetList : ArrayList<Planet> = ArrayList()

    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPlanets()
    }

    private fun loadPlanets(){

        clProgressBar.visibility = View.VISIBLE
        ivProgressBar.setBackgroundResource(R.drawable.load_progressbar)
        animationDrawable = ivProgressBar.background as AnimationDrawable
        animationDrawable.start()

        loadPlanet(object : Load{
            override fun onLoad() {
                clProgressBar.visibility = View.GONE
            }

            override fun onErrorLoad() {
                clProgressBar.visibility = View.GONE
                Toast.makeText(context, getString(R.string.list_error), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadPlanet(load : Load){
        val builderPlanet = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        val planet = builderPlanet.build()

        val starwarsService = planet.create(StarwarsService::class.java)

        getPlanet(starwarsService, load)
    }

    private fun getPlanet(starwarsService: StarwarsService?, load: Load) {
        val call = starwarsService!!.getPlanets(count)

        call.enqueue(object : Callback<PlanetList>{
            override fun onFailure(call: Call<PlanetList>, t: Throwable) {
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<PlanetList>, response: Response<PlanetList>) {
                val planet = response!!.body()
                for (i in 0..planet!!.results.size -1){
                    planetList.add(Planet(planet.results[i].name,
                            planet.results[i].rotation_period,
                            planet.results[i].orbital_period,
                            planet.results[i].diameter,
                            planet.results[i].climate,
                            planet.results[i].gravity,
                            planet.results[i].terrain,
                            planet.results[i].surface_water,
                            planet.results[i].population,
                            planet.results[i].residents,
                            planet.results[i].films))
                }
                if (count <= 6){
                    count++
                    getPlanet(starwarsService, load)
                }else{
                    if (rvList != null){
                        rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                        rvList.adapter = PlanetListAdapter(planetList, view!!.context, { item: Planet -> planetClicked(item) })
                        load.onLoad()
                    }else{
                        load.onErrorLoad()
                    }
                }
            }
        })
    }

    private fun planetClicked(item: Planet) {
        (activity as MainActivity).openPlanet(item)
    }


}