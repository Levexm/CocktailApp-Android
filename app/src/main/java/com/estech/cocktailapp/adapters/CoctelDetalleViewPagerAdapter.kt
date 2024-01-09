package com.estech.cocktailapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.estech.cocktailapp.fragments.DescripcionCoctelFragment
import com.estech.cocktailapp.fragments.ListaRecetaFragment

class CoctelDetalleViewPagerAdapter(
    activity: FragmentActivity
): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return (2)
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) DescripcionCoctelFragment() else ListaRecetaFragment()
    }

}