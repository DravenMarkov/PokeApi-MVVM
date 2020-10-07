package com.example.pokeapi.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.viewmodel.HomeViewModel
import com.example.pokeapi.R
import com.example.pokeapi.domain.entity.PokedexEntity
import com.example.pokeapi.ui.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Set the view model
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        //Get the list of pokémon
        viewModel.getListPokedex()
        val pokedexObserver = Observer<PokedexEntity> {
            Log.d("Pokedex", it.toString())
            pokedex_recycler.adapter = HomeAdapter(it) {
                navigateToDetail(it)
            }
        }

        viewModel.getListPokedexLiveData().observe(viewLifecycleOwner, pokedexObserver)
    }

    fun navigateToDetail(pokemon: PokedexEntity.Result) {
        findNavController().navigate(
            R.id.action_home_to_detail_dest,
            bundleOf("pokemon_data" to pokemon)
        )
    }

}