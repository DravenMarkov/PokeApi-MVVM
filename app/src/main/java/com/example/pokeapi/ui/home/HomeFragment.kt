package com.example.pokeapi.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


    private lateinit var viewModel: HomeViewModel

    private lateinit var adapter: HomeAdapter

    private var offset = 0

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

        adapter = HomeAdapter(requireContext())

        //Get the first list of pokémon
        viewModel.getListPokedex(0)
        pokedex_recycler.adapter = adapter
        adapter.onItemClick = {
            findNavController().navigate(
                R.id.action_home_to_detail_dest,
                bundleOf("pokemon_data" to it)
            )
        }

        viewModel.getListPokedexLiveData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it as MutableList<PokedexEntity.Result>)
            adapter.notifyDataSetChanged()
        })

        pokedex_recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    offset += 20
                    viewModel.getListPokedex(offset)
                }
            }
        })
    }

}