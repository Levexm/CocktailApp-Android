package com.estech.cocktailapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.estech.cocktailapp.fragments.ListaCategoria
import com.estech.cocktailapp.fragments.ListaCoctelesAlcohol
import com.estech.cocktailapp.fragments.ListaCoctelesNoAlcohol

class ListaCoctelesViewPagerAdapter(
    activity: FragmentActivity
): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return (2)
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) ListaCoctelesAlcohol() else ListaCoctelesNoAlcohol()
    }

}