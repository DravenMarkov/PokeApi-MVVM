package com.example.pokeapi.domain.usecase

import com.example.pokeapi.domain.entity.PokedexEntity

class GetPokedexUseCase {

    fun getPokedex(): PokedexEntity {
        return PokedexEntity(
            1, "", "",
            listOf(
                PokedexEntity.Result("Bulbasaur", ""),
                PokedexEntity.Result("Ivysaur", ""),
                PokedexEntity.Result("Venusaur", ""),
                PokedexEntity.Result("Charmander", ""),
                PokedexEntity.Result("Charmaleon", ""),
                PokedexEntity.Result("Charizard", "")
            )
        )
    }
}