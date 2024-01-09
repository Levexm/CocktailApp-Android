package com.estech.cocktailapp.data

import com.squareup.moshi.Json

data class Category(
    @Json(name = "strCategory")
    val strCategory: String
)
