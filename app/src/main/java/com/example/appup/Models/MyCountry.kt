package com.example.appup.Models

data class MyCountry(
    val name: String,
    val subregion: String,
    val region: String,
    val population: Int,
    val demonym: String,
    val timezones: List<String>,
    val flags: Flags,
)
data class Flags(
    val png: String
)
