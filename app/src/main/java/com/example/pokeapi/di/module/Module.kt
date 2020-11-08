package com.example.pokeapi.di.module

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.pokeapi.data.api.PokeApi
import com.example.pokeapi.data.database.PokemonDatabase
import com.example.pokeapi.utils.Consts
import com.example.pokeapi.viewmodel.DetailViewModel
import com.example.pokeapi.viewmodel.HomeViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single { provideDataBase(get()) }

    viewModel { HomeViewModel(get()) }

    viewModel { DetailViewModel() }

}

val netModule = module {
    single { provideGson() }

    single {
        providesRetrofit(get(), get())
    }


    single {
        provideOkHttpClient()
    }

    single { providePokeApiServices(get()) }
}

fun provideGson(): Gson =
    GsonBuilder().create()

fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(Consts.BASE_URL)
        .client(okHttpClient)
        .build()


fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(60 * 1000.toLong(), TimeUnit.MILLISECONDS)
        .readTimeout(60 * 1000.toLong(), TimeUnit.MILLISECONDS)
        .build()

fun providePokeApiServices(retrofit: Retrofit): PokeApi =
    retrofit.create(PokeApi::class.java)

fun provideDataBase(context: Context) : PokemonDatabase =
    PokemonDatabase.getDatabaseInstance(context)
