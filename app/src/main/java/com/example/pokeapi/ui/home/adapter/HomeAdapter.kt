package com.example.pokeapi.ui.home.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapi.R
import com.example.pokeapi.domain.entity.PokedexEntity
import kotlinx.android.synthetic.main.detail_fragment.view.pokemon_image_iv
import kotlinx.android.synthetic.main.view_item_pokemon.view.*

class HomeAdapter(
    private val context: Context
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    var onItemClick: ((PokedexEntity.Result) -> Unit)? = null

    private var pokedexList = listOf<PokedexEntity.Result>()

    fun setListData(list: MutableList<PokedexEntity.Result>) {
        pokedexList = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(pokemon: PokedexEntity.Result) {
            itemView.pokemon_name_tv.text = pokemon.name.capitalize()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_pokemon, null, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pokedexList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(pokedexList[position])
        //Get pokedex number of the pokémon, I know, that is a little weird
        val pokeNumber = pokedexList[position].url.split("/")[6]
        Glide.with(context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokeNumber.png")
            .into(holder.itemView.pokemon_image_iv)
        holder.itemView.setOnClickListener { onItemClick?.invoke(pokedexList[position]) }
    }
}