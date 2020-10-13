package com.example.pokeapi.di.module

import com.example.pokeapi.BuildConfig
import com.example.pokeapi.data.api.PokeApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
class NetModule {


    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder().create()

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson, @Named("okHttpClient") okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("")//BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()


    @Named("okHttpClient")
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(60 * 1000.toLong(), TimeUnit.MILLISECONDS)
            .readTimeout(60*1000.toLong(), TimeUnit.MILLISECONDS)
            .build()

    @Provides
    fun providePokeApiServices(retrofit: Retrofit): PokeApi = retrofit.create(PokeApi::class.java)
}