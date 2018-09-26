package com.example.davidarribas.starwars.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Planet
import kotlinx.android.synthetic.main.fragment_planet.*

class PlanetFragment : Fragment() {
    lateinit var planet : Planet

    companion object {
        fun newInstance(planet: Planet) : PlanetFragment{
            val fragment = PlanetFragment()
            val args = Bundle()
            args.putSerializable("planet", planet)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        planet = arguments!!.getSerializable("planet") as Planet
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_planet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
    }

    @SuppressLint("SetTextI18n")
    private fun setText() {
        tvName.text = planet.name
        tvRotation.text = tvRotation.text.toString() + planet.rotation_period
        tvOrbital.text = tvOrbital.text.toString() + planet.orbital_period
        tvDiameter.text = tvDiameter.text.toString() + planet.diameter
        tvClimate.text = tvClimate.text.toString() + planet.climate
        tvGravity.text = tvGravity.text.toString() + planet.gravity
        tvTerrain.text = tvTerrain.text.toString() + planet.terrain
        tvSurface.text = tvSurface.text.toString() + planet.surface_water
        tvPopulation.text = tvPopulation.text.toString() + planet.population
    }
}