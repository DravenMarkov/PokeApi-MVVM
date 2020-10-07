package com.example.pokeapi.data.api

import com.example.pokeapi.data.entity.PokedexData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    companion object {
        const val POKEDEX_URL = "pokemon"
    }

    @GET(POKEDEX_URL)
    fun getPokedex(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Call<PokedexData>
}