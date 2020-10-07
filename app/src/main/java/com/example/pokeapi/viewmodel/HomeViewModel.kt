package com.example.pokeapi.viewmodel

import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.domain.entity.PokedexEntity
import com.example.pokeapi.domain.usecase.GetPokedexUseCase

class HomeViewModel : ViewModel() {

    private val listData = MutableLiveData<PokedexEntity>()

    private val pokedexUseCase = GetPokedexUseCase()

    // TODO change approach t
  /*  init {
        getListPokedex()
    }*/

    fun setListData(listPokedex: PokedexEntity) {
        listData.value = listPokedex
    }

    fun getListPokedex() {
        setListData(pokedexUseCase.getPokedex())
    }

    fun getListPokedexLiveData(): LiveData<PokedexEntity> {
        return listData
    }
}