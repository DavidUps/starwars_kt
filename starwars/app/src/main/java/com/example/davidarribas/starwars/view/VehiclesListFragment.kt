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
import com.example.davidarribas.starwars.adapters.VehiclesListAdapter
import com.example.davidarribas.starwars.model.Vehicles
import com.example.davidarribas.starwars.model.VehiclesList
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VehiclesListFragment: Fragment() {

    private var count = 1
    private var vehiclesList : ArrayList<Vehicles> = ArrayList()

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

        loadVehicles(object : Load{
            override fun onLoad() {
                clProgressBar.visibility = View.GONE
            }

            override fun onErrorLoad() {
                clProgressBar.visibility = View.GONE
                Toast.makeText(context, getString(R.string.list_error), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadVehicles(load: Load) {
        val builderVehicle= Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())

        val vehicles = builderVehicle.build()

        val starwarsService = vehicles.create(StarwarsService::class.java)

        getVehicle(starwarsService, load)
    }

    private fun getVehicle(starwarsService: StarwarsService?, load: Load) {
        val call = starwarsService!!.getvehicles(count)

        call.enqueue(object : Callback<VehiclesList> {
            override fun onFailure(call: Call<VehiclesList>, t: Throwable) {
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<VehiclesList>, response: Response<VehiclesList>) {
                val vehicles= response!!.body()
                for (i in 0 until vehicles!!.results.size){
                    vehiclesList.add(Vehicles(
                            vehicles.results[i].name,
                            vehicles.results[i].model,
                            vehicles.results[i].manufacturer,
                            vehicles.results[i].cost_in_credits,
                            vehicles.results[i].length,
                            vehicles.results[i].max_atmosphering_speed,
                            vehicles.results[i].crew,
                            vehicles.results[i].passengers,
                            vehicles.results[i].cargo_capacity,
                            vehicles.results[i].consumables,
                            vehicles.results[i].vehicle_class))
                }
                if (count <= 3){
                    count++
                    getVehicle(starwarsService, load)
                }else{
                    if (rvList != null){
                        rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                        rvList.adapter = VehiclesListAdapter(vehiclesList, view!!.context) { item: Vehicles -> vehiclesClicked(item) }
                        load.onLoad()
                    }else{
                        load.onErrorLoad()
                    }
                }
            }
        })
    }
    private fun vehiclesClicked(item: Vehicles){
        (activity as MainActivity).openVehicles(item)
    }
}