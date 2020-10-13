package com.example.pokeapi.di.component

import com.example.pokeapi.di.module.FragmentModule
import com.example.pokeapi.di.scope.PerFragment
import com.example.pokeapi.ui.DetailFragment
import com.example.pokeapi.ui.home.HomeFragment
import dagger.Component

@PerFragment
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailFragment)
}