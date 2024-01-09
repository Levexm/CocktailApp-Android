package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.activities.MainActivity
import com.estech.cocktailapp.adapters.CoctelDetalleViewPagerAdapter
import com.estech.cocktailapp.adapters.ListaCoctelesViewPagerAdapter
import com.estech.cocktailapp.databinding.DetalleCoctelBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetalleCoctelFragment : Fragment() {

    private lateinit var binding: DetalleCoctelBinding
    private var coctelName = "testing"

    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetalleCoctelBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewpager.adapter = CoctelDetalleViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab,position ->
            tab.text = if (position == 0) "Detalles" else "Receta"
        }.attach()

        myViewModel.selectedCoctel.observe(viewLifecycleOwner) {

            coctelName = it.strDrink

            Glide.with(this)
                .load(it.strDrinkThumb)
                .into(binding.ivCatImage)

            it?.idDrink?.let { it1 -> myViewModel.getFullCoctelById(it1) }
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setupActionBar2(binding.toolbar)
        (requireActivity() as MainActivity).supportActionBar?.title = coctelName
    }
}