package com.example.pokeapi.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class PokedexEntity(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
) {
    @Parcelize
    data class Result(
        val name: String,
        val url: String
    ) : Parcelable
}