package com.example.pokeapi.di.module

import android.app.Application
import android.content.Context
import com.example.pokeapi.di.scope.PerAplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: Application) {

    @Provides
    @Singleton
    @PerAplication
    fun provideApplication(): Application = baseApp

    @Provides
    fun provideContext(): Context = baseApp.applicationContext


    //region Repository

    //end region
}