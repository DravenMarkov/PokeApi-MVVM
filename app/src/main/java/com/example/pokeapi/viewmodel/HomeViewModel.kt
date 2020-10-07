package com.example.pokeapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.data.entity.PokedexData
import com.example.pokeapi.domain.entity.PokedexEntity
import com.example.pokeapi.domain.mapper.PokedexMapper
import com.example.pokeapi.utils.Consts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {

    private val listData = MutableLiveData<List<PokedexEntity.Result>>()

    private val list = mutableListOf<PokedexEntity.Result>()

    private var offset = 0

    fun setListData(listPokedex: List<PokedexEntity.Result>) {

        list.addAll(listPokedex)
        listData.value = list
    }

    fun getListPokedex() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeService = retrofit.create(PokeApi::class.java)

        val call = pokeService.getPokedex(offset)
        offset += 20

        call.enqueue(object : Callback<PokedexData> {
            override fun onResponse(call: Call<PokedexData>, response: Response<PokedexData>) {
                if (response.isSuccessful) {
                    setListData(PokedexMapper.convert(response.body()!!.results))
                }
            }

            override fun onFailure(call: Call<PokedexData>, t: Throwable) {
                Log.e("ERROR_GETTING_DATA", t.localizedMessage)
            }
        })
    }

    fun getListPokedexLiveData(): LiveData<List<PokedexEntity.Result>> {
        return listData
    }
}