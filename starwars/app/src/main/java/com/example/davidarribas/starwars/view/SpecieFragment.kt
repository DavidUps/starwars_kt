package com.example.davidarribas.starwars.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Species
import kotlinx.android.synthetic.main.fragment_species.*

class SpecieFragment : Fragment(){

    lateinit var species: Species

    companion object {
        fun newInstance(species: Species) : SpecieFragment{
            val fragment = SpecieFragment()
            val args = Bundle()
            args.putSerializable("species", species)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        species = arguments!!.getSerializable("species") as Species
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_species, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
    }

    @SuppressLint("SetTextI18n")
    private fun setText() {
        tvName.text = species.name
        tvClasification.text = tvClasification.text.toString() + species.classification
        tvDesignation.text = tvDesignation.text.toString() + species.designation
        tvAverageHeight.text = tvAverageHeight.text.toString() + species.average_height
        tvSkinColor.text = tvSkinColor.text.toString() + species.skin_colors
        tvHairColors.text = tvHairColors.text.toString() + species.hair_colors
        tvEyeColors.text = tvEyeColors.text.toString() + species.eye_colors
        tvAverageHeight.text = tvAverageHeight.text.toString() + species.average_height
        tvLanguage.text = tvLanguage.text.toString() + species.language
    }
}