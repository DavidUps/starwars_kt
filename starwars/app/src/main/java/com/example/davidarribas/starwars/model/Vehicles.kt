package com.example.davidarribas.starwars.model

import java.io.Serializable

class Vehicles(val name: String,
               val model: String,
               val manufacturer: String,
               val cost_in_credits: String,
               val length: String,
               val max_atmosphering_speed: String,
               val crew: String,
               val passengers: String,
               val cargo_capacity: String,
               val consumables: String,
               val vehicle_class: String): Serializable
