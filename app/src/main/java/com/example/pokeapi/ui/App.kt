package com.example.pokeapi.ui

import android.app.Application
import com.example.pokeapi.di.component.ApplicationComponent
import com.example.pokeapi.di.component.DaggerApplicationComponent
import com.example.pokeapi.di.module.ApplicationModule

class App : Application(){

    companion object{
        lateinit var baseComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
            .apply { inject(this@App)}
    }
}