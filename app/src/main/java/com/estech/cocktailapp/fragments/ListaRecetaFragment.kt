package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.databinding.ListaRecetaBinding

class ListaRecetaFragment : Fragment() {

    private lateinit var binding: ListaRecetaBinding
    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListaRecetaBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.fullCoctel.observe(viewLifecycleOwner) {

            if (!(it.strIngredient1.isNullOrEmpty() && it.strMeasure1.isNullOrEmpty())) {
                binding.tvIngredient1.text = it.strIngredient1
                binding.tvMeasure1.text = it.strMeasure1
            } else {
                binding.tvIngredient1.visibility = View.GONE
                binding.tvMeasure1.visibility = View.GONE
            }

            if (!(it.strIngredient2.isNullOrEmpty() && it.strMeasure2.isNullOrEmpty())) {
                binding.tvIngredient2.text = it.strIngredient2
                binding.tvMeasure2.text = it.strMeasure2
            } else {
                binding.tvIngredient2.visibility = View.GONE
                binding.tvMeasure2.visibility = View.GONE
            }

            if (!(it.strIngredient3.isNullOrEmpty() && it.strMeasure3.isNullOrEmpty())) {
                binding.tvIngredient3.text = it.strIngredient3
                binding.tvMeasure3.text = it.strMeasure3
            } else {
                binding.tvIngredient3.visibility = View.GONE
                binding.tvMeasure3.visibility = View.GONE
            }

            if (!(it.strIngredient4.isNullOrEmpty() && it.strMeasure4.isNullOrEmpty())) {
                binding.tvIngredient4.text = it.strIngredient4
                binding.tvMeasure4.text = it.strMeasure4
            } else {
                binding.tvIngredient4.visibility = View.GONE
                binding.tvMeasure4.visibility = View.GONE
            }

            if (!(it.strIngredient5.isNullOrEmpty() && it.strMeasure5.isNullOrEmpty())) {
                binding.tvIngredient5.text = it.strIngredient5
                binding.tvMeasure5.text = it.strMeasure5
            } else {
                binding.tvIngredient5.visibility = View.GONE
                binding.tvMeasure5.visibility = View.GONE
            }

            if (!(it.strIngredient6.isNullOrEmpty() && it.strMeasure6.isNullOrEmpty())) {
                binding.tvIngredient6.text = it.strIngredient6
                binding.tvMeasure6.text = it.strMeasure6
            } else {
                binding.tvIngredient6.visibility = View.GONE
                binding.tvMeasure6.visibility = View.GONE
            }

            if (!(it.strIngredient7.isNullOrEmpty() && it.strMeasure7.isNullOrEmpty())) {
                binding.tvIngredient7.text = it.strIngredient7
                binding.tvMeasure7.text = it.strMeasure7
            } else {
                binding.tvIngredient7.visibility = View.GONE
                binding.tvMeasure7.visibility = View.GONE
            }

            if (!(it.strIngredient8.isNullOrEmpty() && it.strMeasure8.isNullOrEmpty())) {
                binding.tvIngredient8.text = it.strIngredient8
                binding.tvMeasure8.text = it.strMeasure8
            } else {
                binding.tvIngredient8.visibility = View.GONE
                binding.tvMeasure8.visibility = View.GONE
            }

            if (!(it.strIngredient9.isNullOrEmpty() && it.strMeasure9.isNullOrEmpty())) {
                binding.tvIngredient9.text = it.strIngredient9
                binding.tvMeasure9.text = it.strMeasure9
            } else {
                binding.tvIngredient9.visibility = View.GONE
                binding.tvMeasure9.visibility = View.GONE
            }

            if (!(it.strIngredient10.isNullOrEmpty() && it.strMeasure10.isNullOrEmpty())) {
                binding.tvIngredient10.text = it.strIngredient10
                binding.tvMeasure10.text = it.strMeasure10
            } else {
                binding.tvIngredient10.visibility = View.GONE
                binding.tvMeasure10.visibility = View.GONE
            }

            if (!(it.strIngredient11.isNullOrEmpty() && it.strMeasure11.isNullOrEmpty())) {
                binding.tvIngredient11.text = it.strIngredient11
                binding.tvMeasure11.text = it.strMeasure11
            } else {
                binding.tvIngredient11.visibility = View.GONE
                binding.tvMeasure11.visibility = View.GONE
            }

            if (!(it.strIngredient12.isNullOrEmpty() && it.strMeasure12.isNullOrEmpty())) {
                binding.tvIngredient12.text = it.strIngredient12
                binding.tvMeasure12.text = it.strMeasure12
            } else {
                binding.tvIngredient12.visibility = View.GONE
                binding.tvMeasure12.visibility = View.GONE
            }

            if (!(it.strIngredient13.isNullOrEmpty() && it.strMeasure13.isNullOrEmpty())) {
                binding.tvIngredient13.text = it.strIngredient13
                binding.tvMeasure13.text = it.strMeasure13
            } else {
                binding.tvIngredient13.visibility = View.GONE
                binding.tvMeasure13.visibility = View.GONE
            }

            if (!(it.strIngredient14.isNullOrEmpty() && it.strMeasure14.isNullOrEmpty())) {
                binding.tvIngredient14.text = it.strIngredient14
                binding.tvMeasure14.text = it.strMeasure14
            } else {
                binding.tvIngredient14.visibility = View.GONE
                binding.tvMeasure14.visibility = View.GONE
            }

            if (!(it.strIngredient15.isNullOrEmpty() && it.strMeasure15.isNullOrEmpty())) {
                binding.tvIngredient15.text = it.strIngredient15
                binding.tvMeasure15.text = it.strMeasure15
            } else {
                binding.tvIngredient15.visibility = View.GONE
                binding.tvMeasure15.visibility = View.GONE
            }

        }
    }
}