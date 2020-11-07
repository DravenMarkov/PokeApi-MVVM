package com.example.pokeapi.ui

import android.app.Application
import com.example.pokeapi.di.appModule
import com.example.pokeapi.di.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, netModule))
        }
    }
}