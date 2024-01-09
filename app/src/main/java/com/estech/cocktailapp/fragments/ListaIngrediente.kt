package com.estech.cocktailapp.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.R
import com.estech.cocktailapp.activities.MainActivity
import com.estech.cocktailapp.adapters.CoctelesAlcoholAdapter
import com.estech.cocktailapp.data.Ingredients
import com.estech.cocktailapp.databinding.ListadoBusquedasBinding

class ListaIngrediente : Fragment(){

    private lateinit var binding: ListadoBusquedasBinding
    private lateinit var dialogOptions: Array<String>

    private val myViewModel by activityViewModels<CoViewModel>{
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = ListadoBusquedasBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        (requireActivity() as MainActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.menu_icon)

        binding.fabSearch.setOnClickListener {

            binding.rvListadoBusqueda.layoutManager= StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

            val adapter= CoctelesAlcoholAdapter(myViewModel, object: CoctelesAlcoholAdapter.OnCocktailClickListener {
                override fun onClick() {
                    findNavController().navigate(R.id.action_listaIngrediente_to_detalleCoctelFragment)
                }
            })
            binding.rvListadoBusqueda.adapter=adapter

            myViewModel.getIng("list").observe(viewLifecycleOwner){
                if (it != null){
                    dialogOptions = getName(it)
                }
                val builder= AlertDialog.Builder(requireContext())
                builder.setItems(dialogOptions){ _, position ->
                    myViewModel.getDrinksByIng(dialogOptions[position]).observe(viewLifecycleOwner){
                        adapter.updateList(it)
                    }
                }
                builder.create().show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setupActionBar(binding.toolbarListadoBusquedas)
        (requireActivity() as MainActivity).supportActionBar?.title = "Búsqueda por ingredientes"
    }

    fun getName(aList: List<Ingredients>): Array<String>{
        return  aList.map { it.strIngredient1 }.toTypedArray()
    }
}