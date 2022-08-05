package com.dhruv.pokemon_dhruv.repositories

import android.util.Log
import com.dhruv.pokemon_dhruv.model.Pokemon
import com.dhruv.pokemon_dhruv.model.PokemonList
import com.dhruv.pokemon_dhruv.network.API
import com.dhruv.pokemon_dhruv.util.Resource

class PokemonRepositoryImpl(
    private val api: API
) : PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getListOfPokemon(limit = limit, offset = offset)
        } catch (e: Exception) {
            Log.d("Exception", "$e")
            return Resource.Error("Something went wrong")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(name: String): Resource<Pokemon>  {
        val response = try{
            api.getPokemonInfo(name)
        }catch (e:Exception){
            Log.d("Exception", "$e")
            return Resource.Error("Something went wrong")
        }
        return Resource.Success(response)
    }
}