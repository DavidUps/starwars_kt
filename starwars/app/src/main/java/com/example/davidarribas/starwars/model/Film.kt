package com.example.davidarribas.starwars.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import java.util.*

@SuppressLint("ParcelCreator")
data class Film (val title: String,
                 val episode_id: Int,
                 val opening_crawl: String,
                 val director: String,
                 val producer: String,
                 val release_date: String,
                 val characters: ArrayList<String>,
                 val planets: ArrayList<String>,
                 val vehicles: ArrayList<String>,
                 val species: ArrayList<String>,
                 val created: String,
                 val edited: String,
                 val url: String) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            TODO("characters"),
            TODO("planets"),
            TODO("vehicles"),
            TODO("species"),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeToParcel(dest: Parcel, flags: Int){
        with(dest){
            writeString(title)
            writeInt(episode_id)
            writeString(opening_crawl)
            writeString(director)
            writeString(producer)
            writeString(release_date)
            writeList(characters)
            writeList(planets)
            writeList(vehicles)
            writeList(species)
            writeString(created)
            writeString(edited)
            writeString(url)

        }
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }



    }

}
