package com.dhruv.pokemon_dhruv.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhruv.pokemon_dhruv.model.Pokemon
import com.dhruv.pokemon_dhruv.repositories.PokemonRepository
import com.dhruv.pokemon_dhruv.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonInfoViewModel @Inject constructor(
    private val repository: PokemonRepository
) :ViewModel(){

    val pokemonInfoState = MutableStateFlow<Resource<Pokemon>>(Resource.Empty())


     fun getPokemonInfo(name:String) : Job = viewModelScope.launch {
         val res = repository.getPokemonInfo(name)
         when(res){
             is Resource.Success->{
                 pokemonInfoState.value = res
             }
             is Resource.Error->{
                 Log.d("Error","${res.message}")
             }
             else->Unit
         }
     }
}