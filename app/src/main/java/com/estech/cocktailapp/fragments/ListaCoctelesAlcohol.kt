package com.estech.cocktailapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.R
import com.estech.cocktailapp.activities.MainActivity
import com.estech.cocktailapp.adapters.CoctelesAlcoholAdapter
import com.estech.cocktailapp.databinding.ListaCoctelesBinding

class ListaCoctelesAlcohol : Fragment() {

    private lateinit var binding: ListaCoctelesBinding

    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListaCoctelesBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        val adapter = CoctelesAlcoholAdapter(myViewModel, object : CoctelesAlcoholAdapter.OnCocktailClickListener {
            override fun onClick() {
                findNavController().navigate(R.id.action_listadoCoctelesInicial_to_detalleCoctelFragment)
            }

        })
        binding.recyclerview.adapter = adapter
        myViewModel.getAlcohol("Alcoholic")

        binding.swipe.setOnRefreshListener {
            myViewModel.getAlcohol("Alcoholic")
        }

        myViewModel.drinksLiveData.observe(viewLifecycleOwner) {
            binding.swipe.isRefreshing = false
            if (it != null)
                adapter.updateList(it)
        }
    }
}