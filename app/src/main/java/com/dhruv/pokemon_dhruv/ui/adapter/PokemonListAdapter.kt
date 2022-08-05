package com.dhruv.pokemon_dhruv.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dhruv.pokemon_dhruv.databinding.PokemonItemBinding
import com.dhruv.pokemon_dhruv.model.MyPokemonList
import com.dhruv.pokemon_dhruv.model.PokemonList

class PokemonListAdapter(
    private val context: Context
) : RecyclerView.Adapter<PokemonListAdapter.MyViewHolder>() {

    inner class MyViewHolder(val itemViewItemBinding: PokemonItemBinding) :
        RecyclerView.ViewHolder(itemViewItemBinding.root) {

    }

    private val differCallback = object : DiffUtil.ItemCallback<MyPokemonList>(){
        override fun areItemsTheSame(oldItem: MyPokemonList, newItem: MyPokemonList): Boolean {
            return oldItem.pokemonNumber == newItem.pokemonNumber
        }

        override fun areContentsTheSame(oldItem: MyPokemonList, newItem: MyPokemonList): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            PokemonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.itemViewItemBinding.apply {
            pokemonName.text = item.pokemonName
            Glide.with(context).load(item.pokemonImageUrl).centerCrop().circleCrop().into(pokemonImage)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}
