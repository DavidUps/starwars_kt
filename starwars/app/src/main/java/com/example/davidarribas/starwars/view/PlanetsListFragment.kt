package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.StarwarsService
import com.example.davidarribas.starwars.model.Planet
import com.example.davidarribas.starwars.model.PlanetList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlanetsListFragment: Fragment() {

    private val BASE_URL = "https://swapi.co/api/"
    private var count = 1
    private var planetList : ArrayList<Planet> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPlanets()
    }

    private fun loadPlanets(){
        val builderPlanet = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        val planet = builderPlanet.build()

        val starWarsService = planet.create(StarwarsService::class.java)

        getPlanet(starWarsService)
    }

    private fun getPlanet(starwarsService: StarwarsService){
        val call = starwarsService.getPlanets(count)

        call.enqueue(object : Callback<PlanetList>{
            override fun onFailure(call: Call<PlanetList>?, t: Throwable?) {
                t!!.printStackTrace()
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<PlanetList>?, result: Response<PlanetList>?) {
                val planet = result!!.body()
                for (i in 0..planet!!.results.size -1){
                 //   planetList.add(Planet(planetz))
                }
            }

        })
    }
}