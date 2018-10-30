package com.example.davidarribas.starwars.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Vehicles

class VehiclesFragment : Fragment() {

    lateinit var vehicles: Vehicles

    companion object {
        fun newInstance(vehicles: Vehicles): VehiclesFragment {
            val fragment = VehiclesFragment()
            val args = Bundle()
            args.putSerializable("vehicles", vehicles)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vehicles = arguments!!.getSerializable("vehicles") as Vehicles
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vehicles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
    }

    @SuppressLint("SetTextI18n")
    private fun setText() {
        /*tvName.text = starships.name
        tvModel.text = tvModel.text.toString() + starships.model
        tvManufacturer.text = tvManufacturer.text.toString() + starships.manufacturer
        tvCostInCredits.text = tvCostInCredits.text.toString() + starships.cost_in_credits
        tvLength.text = tvLength.text.toString() + starships.length
        tvMaxAtmosphering_speed.text = tvMaxAtmosphering_speed.text.toString() + starships.max_atmosphering_speed
        tvCrew.text = tvCrew.text.toString() + starships.crew
        tvPassengers.text = tvPassengers.text.toString() + starships.passengers
        tvCargoCapacity.text = tvCargoCapacity.text.toString() + starships.cargo_capacity
        tvConsumables.text = tvConsumables.text.toString() + starships.consumables
        tvHyperdriveRating.text = tvHyperdriveRating.text.toString() + starships.hyperdrive_rating
        tvMGLT.text = tvMGLT.text.toString() + starships.MGLT
        tvStarshipClass.text = tvStarshipClass.text.toString() + starships.starship_class
        */
    }
}