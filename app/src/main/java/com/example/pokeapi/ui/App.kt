package com.example.pokeapi.ui

import android.app.Application
import com.example.pokeapi.di.module.appModule
import com.example.pokeapi.di.module.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                appModule,
                netModule
            ))
        }
    }
}