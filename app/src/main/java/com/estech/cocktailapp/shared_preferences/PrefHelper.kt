package com.estech.cocktailapp.shared_preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class PrefHelper(context: Context) {

    val sharedPrefHelper = context.getSharedPreferences(
        Constants.PREFER,
        AppCompatActivity.MODE_PRIVATE
    )
    val editor = sharedPrefHelper.edit()

    fun getUsername() = sharedPrefHelper.getString(Constants.USER, "")

    fun putUsername(username: String) {
        editor.putString(Constants.USER, username)
        editor.apply()
    }

    fun getCurrDate() = sharedPrefHelper.getString(Constants.DATE, "")

    fun putCurrDate(currDate: String) {
        editor.putString(Constants.DATE, currDate)
        editor.apply()
    }

}