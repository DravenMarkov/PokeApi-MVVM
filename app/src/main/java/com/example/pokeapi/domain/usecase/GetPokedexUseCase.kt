package com.example.pokeapi.domain.usecase

import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.domain.entity.PokedexEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetPokedexUseCase {

    private lateinit var listPokemon: PokedexEntity

    fun  getPokedex(): PokedexEntity {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeService = retrofit.create(PokeApi::class.java)

        val call = pokeService.getPokedex(20)



        /*val result = call.enqueue(object : Callback<PokedexData> {
            override fun onResponse(call: Call<PokedexData>, response: Response<PokedexData>) {
                if (response.isSuccessful) {
                    listPokemon = PokedexMapper.convert(response.body()!!)

                }
            }

            override fun onFailure(call: Call<PokedexData>, t: Throwable) {
                Log.e("ERROR GETTING DATA", t.localizedMessage)
                listPokemon = PokedexEntity(
                    1, "", "",
                    listOf(
                        PokedexEntity.Result("Bulbasaur", ""),
                        PokedexEntity.Result("Ivysaur", ""),
                        PokedexEntity.Result("Venusaur", ""),
                        PokedexEntity.Result("Charmander", ""),
                        PokedexEntity.Result("Charmaleon", ""),
                        PokedexEntity.Result("Charizard", "")
                    )
                )
            }
        }) */
        val result = call.execute().body()


        return listPokemon

        /*return PokedexEntity(
            1, "", "",
            listOf(
                PokedexEntity.Result("Bulbasaur", ""),
                PokedexEntity.Result("Ivysaur", ""),
                PokedexEntity.Result("Venusaur", ""),
                PokedexEntity.Result("Charmander", ""),
                PokedexEntity.Result("Charmaleon", ""),
                PokedexEntity.Result("Charizard", "")
            )
        )*/
    }
}