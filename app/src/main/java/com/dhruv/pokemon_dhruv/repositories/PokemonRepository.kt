package com.dhruv.pokemon_dhruv.repositories

import com.dhruv.pokemon_dhruv.model.Pokemon
import com.dhruv.pokemon_dhruv.model.PokemonList
import com.dhruv.pokemon_dhruv.util.Resource

interface PokemonRepository {

    suspend fun getPokemonList(limit:Int,offset:Int):Resource<PokemonList>
    suspend fun getPokemonInfo(name:String): Resource<Pokemon>
}