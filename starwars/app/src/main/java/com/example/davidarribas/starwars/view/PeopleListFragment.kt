package com.example.davidarribas.starwars.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.davidarribas.starwars.R
import com.example.davidarribas.starwars.StarwarsService
import com.example.davidarribas.starwars.adapters.PersonListAdapter
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
    private var count = 1

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

    private fun loadPeople() {
        val builderPerson = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        val person = builderPerson.build()

        val starWarsClient = person.create(StarwarsService::class.java!!)

        getPeople(starWarsClient)


    }

    private fun getPeople(starWarsClient: StarwarsService) {
        val call = starWarsClient.getPeople(count)

        call.enqueue(object : Callback<PersonList> {
            override fun onFailure(call: Call<PersonList>?, t: Throwable?) {
                t!!.printStackTrace()
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<PersonList>?, response: Response<PersonList>?) {
                val person = response!!.body()
                for (i in 0..person!!.results.size - 1) {
                    personList.add(Person(person.results[i].name,
                            person.results[i].height, person.results[i].mass, person.results[i].hair_color, person.results[i].skin_color,
                            person.results[i].eye_color, person.results[i].birth_year, person.results[i].gender, person.results[i].homeworld,
                            person.results[i].films, person.results[i].species, person.results[i].vehicles, person.results[i].starships))
                }
                if (count <= 8
                ){
                    count++
                    getPeople(starWarsClient)
                }else{
                    rvList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                    rvList.adapter = PersonListAdapter(personList, view!!.context, { item: Person -> personClicked(item) })
                }

            }
        })
    }

    private fun personClicked(person: Person) {
        //(activity as MainActivity).openFilmFramgent(person)
    }
}