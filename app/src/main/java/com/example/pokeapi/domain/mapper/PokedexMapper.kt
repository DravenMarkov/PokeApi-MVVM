package com.example.pokeapi.domain.mapper

import com.example.pokeapi.data.entity.PokedexData
import com.example.pokeapi.domain.entity.PokedexEntity

class PokedexMapper {

    companion object {

        fun convert(listPokemon: List<PokedexData.Result>): List<PokedexEntity.Result> =
            listPokemon.map { convert(it) }


        fun convert(model: PokedexData.Result): PokedexEntity.Result = with(model) {
            PokedexEntity.Result(
                name = name,
                url = url
            )
        }
    }
}