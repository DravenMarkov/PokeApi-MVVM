package com.example.pokeapi.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.pokeapi.viewmodel.DetailViewModel
import com.example.pokeapi.R
import com.example.pokeapi.data.database.PokemonDatabase
import com.example.pokeapi.ui.base.BaseFragment
import com.example.pokeapi.utils.Utils
import kotlinx.android.synthetic.main.detail_fragment.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    private val viewModel by viewModel<DetailViewModel>()

    private val databaseInstance by inject<PokemonDatabase>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun bindLayout(): Int = R.layout.detail_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pokemonData: String = arguments?.getString("pokemon_url").toString()

        //Get pokédex number of the pokémon, I know it's little weird
        val pokedexNumber = Utils.getPokemonNumber(pokemonData)

        viewModel.setInstanceOfDb(databaseInstance)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            viewModel.getPokemonDb(pokedexNumber)
        } else {
            viewModel.getPokemon(pokedexNumber)
        }

        viewModel.getPokemonLiveData().observe(viewLifecycleOwner, Observer {
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${it.pokedex_number}.png")
                .into(pokemon_image_iv)
            pokemon_number_value_tv.text = it.pokedex_number.toString()
            pokemon_name_value_tv.text = it.name.capitalize()

        })
    }


}