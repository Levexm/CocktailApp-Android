package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.databinding.DescriptionCoctelBinding

class DescripcionCoctelFragment : Fragment() {

    private lateinit var binding: DescriptionCoctelBinding

    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DescriptionCoctelBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.fullCoctel.observe(viewLifecycleOwner) {

            if (!it.strAlcoholic.isNullOrEmpty()) {
                binding.tvAlcoholic.text = it.strAlcoholic
            } else {
                binding.tvAlcoholicLabel.visibility = View.GONE
                binding.tvAlcoholic.visibility = View.GONE
            }

            if (!it.strCategory.isNullOrEmpty()) {
                binding.tvCategory.text = it.strCategory
            } else {
                binding.tvCategoryLabel.visibility = View.GONE
                binding.tvCategory.visibility = View.GONE
            }

            if (!it.strIBA.isNullOrEmpty()) {
                binding.tvIBA.text = it.strIBA
            } else {
                binding.tvIBALabel.visibility = View.GONE
                binding.tvIBA.visibility = View.GONE
            }

            if (!it.strInstructions.isNullOrEmpty()) {
                binding.tvInstructions.text = it.strInstructions
            } else {
                binding.tvInstructionsLabel.visibility = View.GONE
                binding.tvInstructions.visibility = View.GONE
            }

            if (!it.strTags.isNullOrEmpty()) {
                binding.tvTags.text = it.strTags
            } else {
                binding.tvTagsLabel.visibility = View.GONE
                binding.tvTags.visibility = View.GONE
            }

            if (!it.strGlass.isNullOrEmpty()) {
                binding.tvGlass.text = it.strGlass
            } else {
                binding.tvGlassLabel.visibility = View.GONE
                binding.tvGlass.visibility = View.GONE
            }

        }
    }
}