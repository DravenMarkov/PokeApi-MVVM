package com.example.pokeapi.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    val name: String,
    @PrimaryKey
    val pokedex_number: Int
)
