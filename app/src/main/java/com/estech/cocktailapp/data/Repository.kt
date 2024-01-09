package com.estech.cocktailapp.data

import android.content.Context
import com.estech.cocktailapp.network.RetrofitHelper

class Repository(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    // para obtener según tenga alcohol o no
    suspend fun alcohols(a: String) = retrofit.getDrinksAlc(a)

    // para obtener según la categoría
    suspend fun category(c: String) = retrofit.getDrinkCateg(c)

    suspend fun getDrinksByCateg (c: String) = retrofit.getDrinksByCateg(c)

    // para obtener según el ingrediente
    suspend fun ingredient(i: String) = retrofit.getIngredient(i)

    suspend fun getDrinksByIng(i: String)=retrofit.getDrinksByIng(i)

    // para obtener según el vaso
    suspend fun glass(g: String) = retrofit.getTypeGlass(g)

    suspend fun getDrinksByGlass(g:String) = retrofit.getDrinkByGlass(g)

    // para obtener por id
    suspend fun getFullCoctelById(id: String) = retrofit.getFullCoctelById(id)

    // para obtener coctel random
    suspend fun getRandomCoctel() = retrofit.getRandomCoctel()


}