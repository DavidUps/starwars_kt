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
import com.example.davidarribas.starwars.BuildConfig
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.StarwarsService
import com.example.davidarribas.starwars.adapters.PlanetListAdapter
import com.example.davidarribas.starwars.adapters.SpeciesListAdapter
import com.example.davidarribas.starwars.model.Planet
import com.example.davidarribas.starwars.model.PlanetList
import com.example.davidarribas.starwars.model.Species
import com.example.davidarribas.starwars.model.SpeciesList
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpeciesListFragment: Fragment() {

    private var count = 1
    private var specieList : ArrayList<Species> = ArrayList()

    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSpecies()
    }

    private fun loadSpecies() {
        clProgressBar.visibility = View.VISIBLE
        ivProgressBar.setBackgroundResource(R.drawable.load_progressbar)
        animationDrawable = ivProgressBar.background as AnimationDrawable
        animationDrawable.start()

        loadSpecie(object : Load{
            override fun onLoad() {
                clProgressBar.visibility = View.GONE
            }

            override fun onErrorLoad() {
                clProgressBar.visibility = View.GONE
                Toast.makeText(context, getString(R.string.list_error), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadSpecie(load: Load) {
        val builderPlanet = Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())

        val planet = builderPlanet.build()

        val starwarsService = planet.create(StarwarsService::class.java)

        getSpecie(starwarsService, load)
    }

    private fun getSpecie(starwarsService: StarwarsService?, load: Load) {
        val call = starwarsService!!.getSpecies(count)

        call.enqueue(object : Callback<SpeciesList> {
            override fun onFailure(call: Call<SpeciesList>, t: Throwable) {
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<SpeciesList>, response: Response<SpeciesList>) {
                val species = response!!.body()
                for (i in 0..species!!.results.size -1){
                    specieList.add(Species(
                            species.results[i].name,
                            species.results[i].classification,
                            species.results[i].designation,
                            species.results[i].average_height,
                            species.results[i].skin_colors,
                            species.results[i].hair_colors,
                            species.results[i].eye_colors,
                            species.results[i].average_lifespan,
                            species.results[i].language))
                }
                if (count <= 3){
                    count++
                    getSpecie(starwarsService, load)
                }else{
                    if (rvList != null){
                        rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                        rvList.adapter = SpeciesListAdapter(specieList, view!!.context) { item: Species -> specieClicked(item) }
                        load.onLoad()
                    }else{
                        load.onErrorLoad()
                    }
                }
            }
        })
    }

    private fun specieClicked(item: Species) {
        (activity as MainActivity).openSpecie(item)

    }
}