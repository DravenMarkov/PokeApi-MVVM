package com.example.pokeapi.utils

class Utils {

    companion object{
        fun getPokemonNumber(url: String): Int =
            url.split("/")[6].toInt()
    }

}