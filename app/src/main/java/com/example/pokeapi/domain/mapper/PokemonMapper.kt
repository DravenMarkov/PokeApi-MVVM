package com.example.pokeapi.domain.mapper

import com.example.pokeapi.data.entity.PokemonData
import com.example.pokeapi.domain.entity.PokemonEntity

class PokemonMapper {

    companion object {

        fun convert(model: PokemonData): PokemonEntity = with(model) {
            PokemonEntity(
                name = model.name,
                pokedex_number = model.pokedex_number
            )
        }


    }
}