package com.example.pokeapi.ui.home.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.R
import com.example.pokeapi.domain.entity.PokedexEntity

class HomeAdapter(
    private val poke_db: PokedexEntity,
    private val listener: (PokedexEntity.Result) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val poke_image = itemView.findViewById<ImageView>(R.id.pokemon_image_iv)
        val poke_name = itemView.findViewById<TextView>(R.id.pokemon_name_tv)

        fun setData(pokemon: PokedexEntity.Result) {
            poke_name.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_pokemon, null, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = poke_db.results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(poke_db.results[position])
        holder.itemView.setOnClickListener { listener(poke_db.results[position]) }
    }


}