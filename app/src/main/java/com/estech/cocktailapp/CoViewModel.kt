package com.estech.cocktailapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.estech.cocktailapp.data.Category
import com.estech.cocktailapp.data.Drink
import com.estech.cocktailapp.data.Glasses
import com.estech.cocktailapp.data.Ingredient
import com.estech.cocktailapp.data.FullCoctel
import com.estech.cocktailapp.data.Ingredients
import com.estech.cocktailapp.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoViewModel(val context: Context) : ViewModel() {

    private val repositorio = Repository(context)

    val drinksLiveData = MutableLiveData<List<Drink>?>()
    val nonAlcoholicLiveData = MutableLiveData<List<Drink>?>()

    val selectedCoctel = MutableLiveData<Drink>()
    val fullCoctel = MutableLiveData<FullCoctel>()


    fun getAlcohol(a: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.alcohols(a)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                if (a == "Alcoholic") {
                    drinksLiveData.postValue(miRespuesta?.drinks)
                } else {
                    nonAlcoholicLiveData.postValue(miRespuesta?.drinks)
                }
            }
        }
    }

    fun getCategory(c: String): MutableLiveData<List<Category>?> {
        val cateLiveData = MutableLiveData<List<Category>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.category(c)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                cateLiveData.postValue(miRespuesta?.drinks)
            }
        }
        return cateLiveData
    }

    fun getDrinksByCateg(c: String): MutableLiveData<List<Drink>?> {
        val drinksByCategory = MutableLiveData<List<Drink>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getDrinksByCateg(c)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                drinksByCategory.postValue(miRespuesta?.drinks)
            }
        }
        return drinksByCategory
    }

    fun getIng(i: String):MutableLiveData<List<Ingredients>?> {
        val cateLiveData= MutableLiveData<List<Ingredients>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.ingredient(i)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                cateLiveData.postValue(miRespuesta?.drinks)
            }
        }
        return cateLiveData
    }

    fun getDrinksByIng(i: String): MutableLiveData<List<Drink>?>{
        val drinksByIng= MutableLiveData<List<Drink>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response= repositorio.getDrinksByIng(i)
            if (response.isSuccessful){
                val miRespuesta=response.body()
                drinksByIng.postValue(miRespuesta?.drinks)
            }
        }
        return drinksByIng
    }

    fun getGlass(g: String): MutableLiveData<List<Glasses>?> {
        val glassesList = MutableLiveData<List<Glasses>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.glass(g)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                glassesList.postValue(miRespuesta?.drinks)
            }
        }
        return glassesList
    }

    fun getDrinkByGlass(g: String): MutableLiveData<List<Drink>?>{
        val glassesList2 = MutableLiveData<List<Drink>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getDrinksByGlass(g)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                glassesList2.postValue(miRespuesta?.drinks)
            }
        }
        return glassesList2
    }

    fun getFullCoctelById(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getFullCoctelById(id)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                val listaIds = miRespuesta
                fullCoctel.postValue(listaIds?.drinks?.get(0))
            }
        }
    }

    fun putFullCoctel(coctel: FullCoctel) {
        fullCoctel.postValue(coctel)
    }

    fun chooseDrink(drink: Drink) {
        selectedCoctel.postValue(drink)
    }

    fun getRandomCoctel(): MutableLiveData<List<FullCoctel>?> {
        val randomLiveData = MutableLiveData<List<FullCoctel>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getRandomCoctel()
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                randomLiveData.postValue(miRespuesta?.drinks)
            }
        }
        return randomLiveData
    }


    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }


}