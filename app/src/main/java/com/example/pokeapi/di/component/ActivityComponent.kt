package com.example.pokeapi.di.component

import com.example.pokeapi.di.module.ActivityModule
import com.example.pokeapi.di.scope.PerActivity
import com.example.pokeapi.ui.MainActivity
import dagger.Component

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)

}