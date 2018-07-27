package com.example.davidarribas.starwars.model

import android.os.Parcel
import android.os.Parcelable

class Person (val name: String,
              val height: Int,
              val mass: Int,
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
              ): Parcelable{
    constructor(parcel: String) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            TODO("films"),
            TODO("species"),
            TODO("vehicles"),
            TODO("starships")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(height)
        parcel.writeInt(mass)
        parcel.writeString(hair_color)
        parcel.writeString(skin_color)
        parcel.writeString(eye_color)
        parcel.writeString(birth_year)
        parcel.writeString(gender)
        parcel.writeString(homeworld)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}