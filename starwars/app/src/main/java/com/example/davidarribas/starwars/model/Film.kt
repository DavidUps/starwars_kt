package com.example.davidarribas.starwars.model

data class Film (val title : String,
            val episode_id : Int,
            val opening_crawl : String,
            val director : String,
            val producer: String,
            val release_date: String,
            val characters: ArrayList<String>,
            val planets: ArrayList<String>,
            val vehicles: ArrayList<String>,
            val species: ArrayList<String>,
            val created: String,
            val edited: String,
            val url: String)
