package com.example.davidarribas.starwars.model

import android.os.Parcel
import android.os.Parcelable

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
              val films: ArrayList<String>): Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            TODO("residents"),
            TODO("films")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(rotation_period)
        parcel.writeString(orbital_period)
        parcel.writeString(diameter)
        parcel.writeString(climate)
        parcel.writeString(gravity)
        parcel.writeString(terrain)
        parcel.writeString(surface_water)
        parcel.writeString(population)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Planet> {
        override fun createFromParcel(parcel: Parcel): Planet {
            return Planet(parcel)
        }

        override fun newArray(size: Int): Array<Planet?> {
            return arrayOfNulls(size)
        }
    }
}