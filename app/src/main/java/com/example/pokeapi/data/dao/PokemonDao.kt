package com.example.pokeapi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pokeapi.domain.entity.PokemonEntity
import java.util.*

@Dao
interface PokemonDao {

    @Insert
    fun insert(pokemonEntity: PokemonEntity)

    @Query("SELECT * FROM pokemonentity WHERE pokedex_number = :pokedex_number")
    fun findPokemonByNumber(pokedex_number: Int) : Optional<PokemonEntity>
}