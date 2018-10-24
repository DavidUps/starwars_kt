package com.example.davidarribas.starwars.model

import java.io.Serializable

class Species (val name : String,
               val classification: String,
               val designation : String,
               val average_height : String,
               val skin_colors : String,
               val hair_colors : String,
               val eye_colors : String,
               val average_lifespan : String,
               val language : String) : Serializable