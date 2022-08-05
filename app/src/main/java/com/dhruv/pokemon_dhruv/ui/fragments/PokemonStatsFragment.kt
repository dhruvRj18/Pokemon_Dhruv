package com.dhruv.pokemon_dhruv.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dhruv.pokemon_dhruv.R
import com.dhruv.pokemon_dhruv.databinding.PokemonStatsFragmentBinding
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_NAME
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_NUMBER
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_URL

class PokemonStatsFragment : Fragment(R.layout.pokemon_stats_fragment) {

    private lateinit var binding: PokemonStatsFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokemonStatsFragmentBinding.bind(view)
        val pokemonName = getArguments()?.getString(POKEMON_NAME)
        val pokemonNumber = getArguments()?.getInt(POKEMON_NUMBER)
        val pokemonURL = getArguments()?.getString(POKEMON_URL)

        Log.d("args" , "name : $pokemonName \n number : $pokemonNumber \n url : $pokemonURL")


    }







}