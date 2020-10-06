package com.example.pokeapi.domain.entity

data class PokedexEntity(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
) {
    data class Result(
        val name: String,
        val url: String
    )
}