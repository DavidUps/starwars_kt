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
import com.example.davidarribas.starwars.adapters.StarshipListAdapter
import com.example.davidarribas.starwars.model.Species
import com.example.davidarribas.starwars.model.StarshipList
import com.example.davidarribas.starwars.model.Starships
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StarshipListFragment : Fragment() {

    private var count = 1
    private var starshipsList : ArrayList<Starships> = ArrayList()

    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadStarships()
    }

    private fun loadStarships() {
        clProgressBar.visibility = View.VISIBLE
        ivProgressBar.setBackgroundResource(R.drawable.load_progressbar)
        animationDrawable = ivProgressBar.background as AnimationDrawable
        animationDrawable.start()

        loadStarship(object : Load{
            override fun onLoad() {
                clProgressBar.visibility = View.GONE
            }

            override fun onErrorLoad() {
                clProgressBar.visibility = View.GONE
                Toast.makeText(context, getString(R.string.list_error), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadStarship(load: Load) {
        val builderStarship= Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())

        val starship = builderStarship.build()

        val starwarsService = starship.create(StarwarsService::class.java)

        getStarship(starwarsService, load)
    }

    private fun getStarship(starwarsService: StarwarsService?, load: Load) {
        val call = starwarsService!!.getStarship(count)

        call.enqueue(object : Callback<StarshipList> {
            override fun onFailure(call: Call<StarshipList>, t: Throwable) {
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<StarshipList>, response: Response<StarshipList>) {
                val starships= response!!.body()
                for (i in 0..starships!!.results.size -1){
                    starshipsList.add(Starships(
                            starships.results[i].name,
                            starships.results[i].model,
                            starships.results[i].manufacturer,
                            starships.results[i].cost_in_credits,
                            starships.results[i].length,
                            starships.results[i].max_atmosphering_speed,
                            starships.results[i].crew,
                            starships.results[i].passengers,
                            starships.results[i].cargo_capacity,
                            starships.results[i].consumables,
                            starships.results[i].hyperdrive_rating,
                            starships.results[i].MGLT,
                            starships.results[i].starship_class))
                }
                if (count <= 3){
                    count++
                    getStarship(starwarsService, load)
                }else{
                    if (rvList != null){
                        rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                        rvList.adapter = StarshipListAdapter(starshipsList, view!!.context) { item: Starships -> starshipClicked(item) }
                        load.onLoad()
                    }else{
                        load.onErrorLoad()
                    }
                }
            }
        })
    }
    private fun starshipClicked(item: Starships){
        (activity as MainActivity).openStarship(item)
    }
}