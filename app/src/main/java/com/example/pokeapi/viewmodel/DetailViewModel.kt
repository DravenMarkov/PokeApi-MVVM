package com.example.pokeapi.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.data.database.PokemonDatabase
import com.example.pokeapi.data.entity.PokemonData
import com.example.pokeapi.domain.entity.PokemonEntity
import com.example.pokeapi.domain.mapper.PokemonMapper
import com.example.pokeapi.utils.Consts
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class DetailViewModel : ViewModel() {

    private val pokemon = MutableLiveData<PokemonEntity>()

    // TODO change this aproach to a USE CASE
    private lateinit var pokeDatabaseInstance: PokemonDatabase

    //database logic
    fun setInstanceOfDb(databaseInstance: PokemonDatabase) {
        pokeDatabaseInstance = databaseInstance
    }

    fun savePokemonIntoDb(poke: PokemonEntity) {
        pokeDatabaseInstance.pokemonDao().insert(poke)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getPokemonDb(pokedexNumber: Int) {
        if (pokeDatabaseInstance.pokemonDao().isExist(pokedexNumber)) {
            pokemon.value = pokeDatabaseInstance.pokemonDao().findPokemonByNumber(pokedexNumber)
        } else {
            getPokemon(pokedexNumber)
        }

    }

    //livedata logic
    fun setPokemonData(poke: PokemonEntity) {
        pokemon.value = PokemonEntity(poke.name, poke.pokedex_number)
        savePokemonIntoDb(poke)

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
                    response.body()?.let { data -> setPokemonData(PokemonMapper.convert(data)) }
                }
            }
        })
    }

    fun getPokemonLiveData(): LiveData<PokemonEntity> {
        return pokemon
    }

}