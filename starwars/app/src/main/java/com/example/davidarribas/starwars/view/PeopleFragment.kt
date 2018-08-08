package com.example.davidarribas.starwars.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.model.Person
import kotlinx.android.synthetic.main.fragment_people.*

class PeopleFragment : Fragment() {

    lateinit var person: Person

    companion object {
        fun newInstance(person: Person) : PeopleFragment{
            val fragment = PeopleFragment()
            val args = Bundle()
            args.putParcelable("person", person)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        person = arguments!!.getParcelable("person")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
        /*val ACCELERATE_DECELERATE = AccelerateDecelerateInterpolator()
        val generator = RandomTransitionGenerator(10000, ACCELERATE_DECELERATE)
        imView.setTransitionGenerator(generator)*/
    }

    @SuppressLint("SetTextI18n")
    private fun setText(){
        tvName.text = person.name
        tvHeight.text = tvHeight.text.toString() + person.height
        tvMass.text = tvMass.text.toString() + person.mass
        tvHairColor.text = tvHairColor.text.toString() + person.hair_color
        tvSkinClor.text = tvSkinClor.text.toString() + person.skin_color
        tvEyeColor.text= tvEyeColor.text.toString() + person.eye_color
        tvBirthdayYear.text = tvBirthdayYear.text.toString() + person.birth_year
        tvGender.text = tvGender.text.toString() + person.gender
    }



}