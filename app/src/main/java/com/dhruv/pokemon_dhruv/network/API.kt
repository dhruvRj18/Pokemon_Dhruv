package com.dhruv.pokemon_dhruv.network

import com.dhruv.pokemon_dhruv.model.Pokemon
import com.dhruv.pokemon_dhruv.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    //API endpoints
    @GET("pokemon/")
    suspend fun getListOfPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ):PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon
}