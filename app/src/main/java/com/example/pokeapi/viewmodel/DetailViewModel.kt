package com.example.pokeapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.data.entity.PokemonData
import com.example.pokeapi.domain.entity.PokemonEntity
import com.example.pokeapi.domain.mapper.PokemonMapper
import com.example.pokeapi.utils.Consts
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class DetailViewModel : ViewModel() {

    private val pokemon = MutableLiveData<PokemonEntity>()


    fun setPokemonData(poke: PokemonEntity) {
        pokemon.value = PokemonEntity(poke.name, poke.pokedex_number)

    }

    fun getPokemon(pokedexNumber: Int) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeService = retrofit.create(PokeApi::class.java)

        val call = pokeService.getPokemon(pokedexNumber)

        call.enqueue(object : Callback<PokemonData> {
            override fun onFailure(call: Call<PokemonData>, t: Throwable) {
                Log.e("ERROR_GETTIN_POKEMON", t.localizedMessage)
            }

            override fun onResponse(call: Call<PokemonData>, response: Response<PokemonData>) {
                if (response.isSuccessful) {
                    setPokemonData(PokemonMapper.convert(response.body()!!))
                }

            }
        })
    }

    fun getPokemonLiveData(): LiveData<PokemonEntity> {
        return pokemon
    }

}