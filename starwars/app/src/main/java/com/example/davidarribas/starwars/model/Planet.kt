package com.example.davidarribas.starwars.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Planet (val name: String,
              val rotation_period: String,
              val orbital_period: String,
              val diameter: String,
              val climate: String,
              val gravity: String,
              val terrain: String,
              val surface_water: String,
              val population: String,
              val residents: ArrayList<String>,
              val films: ArrayList<String>): Serializable