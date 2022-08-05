package com.dhruv.pokemon_dhruv.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhruv.pokemon_dhruv.model.MyPokemonList
import com.dhruv.pokemon_dhruv.model.PokemonList
import com.dhruv.pokemon_dhruv.repositories.PokemonRepository
import com.dhruv.pokemon_dhruv.util.Constants.PAGE_SIZE
import com.dhruv.pokemon_dhruv.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class PokemonListViewmodel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private var page = 0


    private val _pokemonlistState =
        MutableStateFlow<List<MyPokemonList>>(listOf())
    val pokemonlistState = _pokemonlistState
    var loadError = MutableStateFlow<String>("")
    var isLoading = MutableStateFlow(false)
    var endOfList = MutableStateFlow(false)


    init {
        getPokemonList()
    }

    fun getPokemonList() = viewModelScope.launch {
        isLoading.value = true

        val result = pokemonRepository.getPokemonList(limit = PAGE_SIZE, offset = page)
        when (result) {
            is Resource.Success -> {
                endOfList.value = page * PAGE_SIZE >= result.data!!.count
                val pokemonList = result.data.results.mapIndexed { index, result ->
                    val pokemonNumber = if (result.url.endsWith("/")) {
                        result.url.dropLast(1).takeLastWhile { it.isDigit() }
                    } else {
                        result.url.takeLastWhile { it.isDigit() }
                    }

                    val pokemonImageUrl =
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokemonNumber.png"
                    MyPokemonList(
                        pokemonName = result.name,
                        pokemonImageUrl = pokemonImageUrl,
                        pokemonNumber = pokemonNumber.toInt()
                    )
                }
                page++
                loadError.value = ""
                isLoading.value = false
                _pokemonlistState.value += pokemonList
            }
            is Resource.Error -> {
                loadError.value = result.message!!
                isLoading.value = false
            }
        }

    }
}





