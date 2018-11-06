package com.example.davidarribas.starwars.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Vehicles
import kotlinx.android.synthetic.main.fragment_vehicles.*

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
        tvName.text = vehicles.name
        tvModel.text = tvModel.text.toString() + vehicles.model
        tvManufacturer.text = tvManufacturer.text.toString() + vehicles.manufacturer
        tvCostInCredits.text = tvCostInCredits.text.toString() + vehicles.cost_in_credits
        tvLength.text = tvLength.text.toString() + vehicles.cost_in_credits
        tvMaxAtmospheringSpeed.text = tvMaxAtmospheringSpeed.text.toString() + vehicles.max_atmosphering_speed
        tvCrew.text = tvCrew.text.toString() + vehicles.crew
        tvPassengers.text = tvPassengers.text.toString() + vehicles.passengers
        tvCargoCapacity.text = tvCargoCapacity.text.toString() + vehicles.cargo_capacity
        tvConsumables.text = tvConsumables.text.toString() + vehicles.consumables
        tvVehicleClass.text = tvVehicleClass.text.toString() + vehicles.vehicle_class
    }
}