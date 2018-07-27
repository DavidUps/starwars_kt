package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.StarwarsService
import com.example.davidarribas.starwars.model.Person
import com.example.davidarribas.starwars.model.PersonList
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PeopleListFragment : Fragment() {

    private val BASE_URL = "https://swapi.co/api/"
    private val personList: ArrayList<Person> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadPeople()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadPeople(){
        val builderPerson = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        val person = builderPerson.build()

        val starWarsClient = person.create(StarwarsService::class.java!!)
        val call = starWarsClient.getPeople()

        call.enqueue(object : Callback<PersonList>{
            override fun onFailure(call: Call<PersonList>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<PersonList>?, response: Response<PersonList>?) {
                val person = response!!.body()
                for (i in 0..person!!.count -1){
                    personList.add(Person(person.result[i].name,
                            person.result[i].height, person.result[i].mass, person.result[i].hair_color, person.result[i].skin_color,
                            person.result[i].eye_color, person.result[i].birth_year, person.result[i].gender, person.result[i].homeworld,
                            person.result[i].films, person.result[i].species,person.result[i].vehicles,person.result[i].starships))
                }

                rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                rvList.adapter =
            }
        })
    }
}