package com.example.pokeapi.data.api

import com.example.pokeapi.data.entity.PokedexData
import com.example.pokeapi.data.entity.PokemonData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    companion object {
        const val POKEDEX_URL = "pokemon"
        const val POKEMON_URL = "pokemon/{pokedexNumber}"
    }

    @GET(POKEDEX_URL)
    fun getPokedex(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Call<PokedexData>

    @GET(POKEMON_URL)
    fun getPokemon(
        @Path("pokedexNumber") pokedexNumber: Int
    ): Call<PokemonData>
}