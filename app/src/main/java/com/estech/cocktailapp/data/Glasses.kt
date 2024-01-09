package com.estech.cocktailapp.data


import com.squareup.moshi.Json

data class Glasses(
    @Json(name = "strGlass")
    val strGlass: String
)