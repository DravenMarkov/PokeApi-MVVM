package com.example.pokeapi.di.module

import com.example.pokeapi.viewmodel.DetailViewModel
import com.example.pokeapi.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides


@Module
class FragmentModule {

    @Provides
    fun provideHomeViewModel(): HomeViewModel = HomeViewModel()

    @Provides
    fun provideDetailViewModel(): DetailViewModel = DetailViewModel()
}