package com.example.pokeapi.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokeapi.viewmodel.DetailViewModel
import com.example.pokeapi.R
import com.example.pokeapi.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.detail_fragment.view.*

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pokemonData: String = arguments?.getString("pokemon_url").toString()


        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        //Get Pokémon
        val pokedexNumber = pokemonData.split("/")[6].toInt()
        viewModel.getPokemon(pokedexNumber)

        viewModel.getPokemonLiveData().observe(viewLifecycleOwner, Observer {
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokedexNumber.png")
                .into(pokemon_image_iv)
            pokemon_name_value_tv.text = it.name.capitalize()

        })
    }


}