package com.example.pokeapi.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
        //val recycler = requireActivity().findViewById<RecyclerView>(R.id.pokedex_recycler)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val pokedexObserver = Observer<PokedexEntity> {
            Log.d("Pokedex", it.toString())
            adapter = HomeAdapter(it)
            pokedex_recycler.adapter = adapter
        }

        viewModel.getListPokedexLiveData().observe(viewLifecycleOwner, pokedexObserver)
    }

}