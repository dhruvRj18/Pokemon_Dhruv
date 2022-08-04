package com.dhruv.pokemon_dhruv.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dhruv.pokemon_dhruv.R
import com.dhruv.pokemon_dhruv.databinding.PokemonListFragmentBinding

class PokemonListFragment: Fragment(R.layout.pokemon_list_fragment) {

    private lateinit var binding: PokemonListFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokemonListFragmentBinding.bind(view)


    }
}