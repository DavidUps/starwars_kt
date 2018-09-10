package com.example.davidarribas.starwars.model

import java.io.Serializable

class Person (val name: String,
              val height: String,
              val mass: String,
              val hair_color: String,
              val skin_color: String,
              val eye_color: String,
              val birth_year: String,
              val gender: String,
              val homeworld: String,
              val films: ArrayList<String>,
              val species: ArrayList<String>,
              val vehicles: ArrayList<String>,
              val starships: ArrayList<String>
              ): Serializable