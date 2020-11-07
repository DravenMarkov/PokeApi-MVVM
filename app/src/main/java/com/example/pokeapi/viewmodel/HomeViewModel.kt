package com.example.pokeapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.data.entity.PokedexData
import com.example.pokeapi.domain.entity.PokedexEntity
import com.example.pokeapi.domain.mapper.PokedexMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(private val pokeService: PokeApi) : ViewModel() {


    private val livePokedexList = MutableLiveData<List<PokedexEntity.Result>>()

    private val pokedexList = mutableListOf<PokedexEntity.Result>()

    private var offset = 0



    fun setListData(listPokedex: List<PokedexEntity.Result>) {

        pokedexList.addAll(listPokedex)
        livePokedexList.value = pokedexList
    }

    fun getListPokedex() {

        // TODO SET THIS AS USE CASE
        val call = pokeService.getPokedex(offset)
        offset += 20

        call.enqueue(object : Callback<PokedexData> {
            override fun onResponse(call: Call<PokedexData>, response: Response<PokedexData>) {
                if (response.isSuccessful) {
                    response.body()
                        ?.let { data -> setListData(PokedexMapper.convert(data.results)) }
                }
            }

            override fun onFailure(call: Call<PokedexData>, t: Throwable) {
                Log.e("ERROR_GETTING_DATA", t.localizedMessage)
            }
        })
    }

    fun getListPokedexLiveData(): LiveData<List<PokedexEntity.Result>> {
        return livePokedexList
    }
}