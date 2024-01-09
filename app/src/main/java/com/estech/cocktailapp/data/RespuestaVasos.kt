package com.estech.cocktailapp.data


import com.squareup.moshi.Json

data class RespuestaVasos(
    @Json(name = "drinks")
    val drinks: List<Glasses>?
)