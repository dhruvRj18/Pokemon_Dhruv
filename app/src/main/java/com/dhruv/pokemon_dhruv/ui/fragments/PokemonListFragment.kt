package com.dhruv.pokemon_dhruv.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhruv.pokemon_dhruv.R
import com.dhruv.pokemon_dhruv.databinding.PokemonListFragmentBinding
import com.dhruv.pokemon_dhruv.ui.adapter.PokemonListAdapter
import com.dhruv.pokemon_dhruv.ui.viewmodels.PokemonListViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListFragment : Fragment(R.layout.pokemon_list_fragment) {

    private lateinit var binding: PokemonListFragmentBinding
    private val pokemonListViewmodel: PokemonListViewmodel by viewModels()
    private lateinit var pokemonListAdapter: PokemonListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokemonListFragmentBinding.bind(view)
        pokemonListAdapter = PokemonListAdapter(requireContext())
        binding.pokemonListRCV.apply {
            adapter = pokemonListAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }



        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                pokemonListViewmodel.pokemonlistState.collectLatest { pokemonList ->

                    pokemonListAdapter.differ.submitList(pokemonList)

                }
            }
        }

        binding.pokemonListRCV.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
               if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)){
                   pokemonListViewmodel.getPokemonList()
               }
            }
        })


    }
}