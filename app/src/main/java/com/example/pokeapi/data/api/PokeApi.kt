package com.example.pokeapi.data.api

interface PokeApi {

    companion object {
        const val POKEDEX_URL = "" //""${Consts.Network.API_VERSION}/pokemon"
    }

   /* @GET(POKEDEX_URL)
    fun getPokedex(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = Consts.Params.LIMIT_POKES
    ): Single<Pokedex>*/


}