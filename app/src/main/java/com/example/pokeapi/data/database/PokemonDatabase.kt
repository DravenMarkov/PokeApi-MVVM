package com.example.pokeapi.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokeapi.data.dao.PokemonDao
import com.example.pokeapi.domain.entity.PokemonEntity


@Database(entities = arrayOf(PokemonEntity::class), version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao


    companion object {

        @Volatile
        private var databaseInstance: PokemonDatabase? = null

        fun getDatabaseInstance(context: Context): PokemonDatabase =
            databaseInstance ?: synchronized(this) {
                databaseInstance ?: buildDatabaseInstance(context).also {
                    databaseInstance = it
                }
            }

        fun buildDatabaseInstance(context: Context) =
            Room.databaseBuilder(
                context, PokemonDatabase::class.java, "POKE_DB"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }

}
