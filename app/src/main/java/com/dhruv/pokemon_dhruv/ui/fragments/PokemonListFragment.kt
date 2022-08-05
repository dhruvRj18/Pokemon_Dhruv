package com.dhruv.pokemon_dhruv.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhruv.pokemon_dhruv.R
import com.dhruv.pokemon_dhruv.databinding.PokemonListFragmentBinding
import com.dhruv.pokemon_dhruv.ui.adapter.PokemonListAdapter
import com.dhruv.pokemon_dhruv.ui.viewmodels.PokemonListViewmodel
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_NAME
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_NUMBER
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_URL
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListFragment : Fragment(R.layout.pokemon_list_fragment), PokemonListAdapter.MyOnItemClickListener {

    private lateinit var binding: PokemonListFragmentBinding
    private val pokemonListViewmodel: PokemonListViewmodel by viewModels()
    private lateinit var pokemonListAdapter: PokemonListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokemonListFragmentBinding.bind(view)
        pokemonListAdapter = PokemonListAdapter(requireContext(),this)
        binding.pokemonListRCV.apply {
            adapter = pokemonListAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }

        if (pokemonListAdapter.differ.currentList.isEmpty()){
            pokemonListViewmodel.getPokemonList()
        }

        getPokemonList()

        checkForListEnd()

        searchPokemon()




    }

    override fun onClick(position: Int) {
        Log.d(
            "clicked","$position"
        )
       val pokemonItem =  pokemonListAdapter.differ.currentList[position]
        val pokemonBundle = Bundle()
        pokemonBundle.putString(POKEMON_NAME,pokemonItem.pokemonName)
        pokemonBundle.putInt(POKEMON_NUMBER,pokemonItem.pokemonNumber)
        pokemonBundle.putString(POKEMON_URL,pokemonItem.pokemonImageUrl)
        findNavController().navigate(R.id.action_pokemonListFragment_to_pokemonStatsFragment,pokemonBundle)
    }


    private fun searchPokemon() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                pokemonListViewmodel.searchPokemon(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                pokemonListViewmodel.searchPokemon(newText!!)
                return true
            }
        })
    }

    private fun getPokemonList() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                pokemonListViewmodel.pokemonlistState.collectLatest { pokemonList ->
                    pokemonListAdapter.differ.submitList(pokemonList)

                }
            }
        }
    }

    private fun checkForListEnd() {
        binding.pokemonListRCV.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN) ) {
                    pokemonListViewmodel.getPokemonList()
                }
            }
        })
    }
}