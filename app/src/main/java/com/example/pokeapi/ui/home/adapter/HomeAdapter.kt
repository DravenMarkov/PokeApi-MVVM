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

    private var poke_db = mutableListOf<PokedexEntity.Result>()

    fun setListData(data: MutableList<PokedexEntity.Result>) {
        poke_db.addAll(data)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(pokemon: PokedexEntity.Result) {
            itemView.pokemon_name_tv.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_pokemon, null, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = poke_db.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(poke_db[position])
        val pokeNumber = position + 1
        Glide.with(context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokeNumber.png")
            .into(holder.itemView.pokemon_image_iv)
        holder.itemView.setOnClickListener { onItemClick?.invoke(poke_db[position]) }
    }
}