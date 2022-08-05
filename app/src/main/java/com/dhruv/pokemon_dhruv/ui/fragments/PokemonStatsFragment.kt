package com.dhruv.pokemon_dhruv.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.dhruv.pokemon_dhruv.R
import com.dhruv.pokemon_dhruv.databinding.PokemonStatsFragmentBinding
import com.dhruv.pokemon_dhruv.ui.viewmodels.PokemonInfoViewModel
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_NAME
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_NUMBER
import com.dhruv.pokemon_dhruv.util.Constants.POKEMON_URL
import com.dhruv.pokemon_dhruv.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonStatsFragment : Fragment(R.layout.pokemon_stats_fragment) {

    private lateinit var binding: PokemonStatsFragmentBinding
    private val viewmodel: PokemonInfoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PokemonStatsFragmentBinding.bind(view)
        val pokemonName = getArguments()?.getString(POKEMON_NAME)
        val pokemonNumber = getArguments()?.getInt(POKEMON_NUMBER)
        val pokemonURL = getArguments()?.getString(POKEMON_URL)
        viewmodel.getPokemonInfo(pokemonName!!)

        Glide.with(requireContext()).load(pokemonURL).centerCrop().circleCrop()
            .into(binding.pokemonStateImage)


        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.pokemonInfoState.collectLatest {
                    when(it){
                        is Resource.Success->{

                            val pokemonInfo = it.data!!

                            for (i in pokemonInfo.stats.indices){
                                val stat = pokemonInfo.stats[i]
                                when(stat.stat.name){
                                     "hp" ->{
                                         binding.hpIndicator.visibility = View.VISIBLE
                                         binding.hpText.visibility = View.VISIBLE
                                        binding.hpIndicator.progress = stat.base_stat

                                    }
                                    "attack" ->{
                                        binding.attackIndicator.visibility = View.VISIBLE
                                        binding.attackText.visibility = View.VISIBLE
                                        binding.attackIndicator.progress = stat.base_stat

                                    }
                                    "defense" ->{
                                        binding.defenceIndicator.visibility = View.VISIBLE
                                        binding.defenseText.visibility = View.VISIBLE
                                        binding.defenceIndicator.progress = stat.base_stat

                                    }
                                    "special-attack" ->{
                                        binding.specialAttackIndicator.visibility = View.VISIBLE
                                        binding.specialAttackText.visibility = View.VISIBLE
                                        binding.specialAttackIndicator.progress = stat.base_stat

                                    }
                                    "special-defense" ->{
                                        binding.specialDefenceIndicator.visibility = View.VISIBLE
                                        binding.specialDefenseText.visibility = View.VISIBLE
                                        binding.specialDefenceIndicator.progress = stat.base_stat

                                    }
                                    "speed" ->{
                                        binding.speedIndicator.visibility = View.VISIBLE
                                        binding.speedText.visibility = View.VISIBLE
                                        binding.speedIndicator.progress = stat.base_stat

                                    }
                                    "accuracy" ->{
                                        binding.accuracyIndicator.visibility = View.VISIBLE
                                        binding.accuracyText.visibility = View.VISIBLE
                                        binding.accuracyIndicator.progress = stat.base_stat

                                    }
                                    "evasion" ->{
                                        binding.evasionIndicator.visibility = View.VISIBLE
                                        binding.evasionText.visibility = View.VISIBLE
                                        binding.evasionIndicator.progress = stat.base_stat

                                    }

                                }
                            }



                            binding.pokemonDetailRank.text = "#"+pokemonInfo.order.toString()
                            binding.pokemonDetailName.text = pokemonName
                            binding.pokemonDetailWeight.text = pokemonInfo.weight.toString()
                            binding.pokemonDetailHeight.text = pokemonInfo.height.toString()


                        }
                        is Resource.Error->{

                        }
                        else->Unit
                    }

                }
            }
        }


    }

}