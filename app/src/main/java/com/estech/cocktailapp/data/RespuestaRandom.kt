package com.estech.cocktailapp.data


import com.squareup.moshi.Json

data class RespuestaRandom(
    @Json(name = "drinks")
    val drinks: List<FullCoctel>?
)