package com.dhruv.pokemon_dhruv.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dhruv.pokemon_dhruv.R
import com.dhruv.pokemon_dhruv.databinding.PokemonStatsFragmentBinding

class PokemonStatsFragment: Fragment(R.layout.pokemon_stats_fragment) {

    private lateinit var binding: PokemonStatsFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokemonStatsFragmentBinding.bind(view)
    }
}