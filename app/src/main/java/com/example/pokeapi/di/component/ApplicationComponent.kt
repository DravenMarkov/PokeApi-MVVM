package com.example.pokeapi.di.component

import android.content.Context
import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.di.module.ApplicationModule
import com.example.pokeapi.di.module.NetModule
import com.example.pokeapi.ui.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetModule::class])
interface ApplicationComponent {

    val context: Context

    val pokeApiService: PokeApi

    fun inject(application: App)

}