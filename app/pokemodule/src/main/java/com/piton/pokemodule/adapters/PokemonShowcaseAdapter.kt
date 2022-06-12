package com.piton.pokemodule.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.piton.pokemodule.R
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.piton.pokemodule.model.PokemonShowcaseResponse

class PokemonShowcaseAdapter(
    private val context: Context,
    private val listPokemons: List<PokemonShowcaseResponse>,
    @LayoutRes
    private val layoutId: Int
) : RecyclerView.Adapter<PokemonShowcaseAdapter.PokemonShowcaseViewHolder>() {

    private val spinner = CircularProgressDrawable(context).apply {
        strokeCap = Paint.Cap.ROUND
        centerRadius = 40f
        strokeWidth = 15f
        start()
    }

    inner class PokemonShowcaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardImage =
            itemView.findViewById<ImageView>(R.id.card_image)
//                ?: itemView.findViewById<ImageView>(R.id.card_image_flipped)
        var cardTitle =
            itemView.findViewById<TextView>(R.id.card_title)
//                ?: itemView.findViewById<TextView>(R.id.card_title_flipped)
//        var cardAttributes =
//            itemView.findViewById<TextView>(R.id.card_attributes_flipped) ?: null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonShowcaseViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)

        return PokemonShowcaseViewHolder(root)
    }

    override fun onBindViewHolder(holder: PokemonShowcaseViewHolder, position: Int) {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(spinner)
        requestOptions.fallback(spinner)
        requestOptions.error(spinner)

        var item = listPokemons[position]

            Glide.with(context)
                .load(item.getImageUrl())
                .apply(requestOptions)
                .into(holder.cardImage)

            holder.cardTitle.text = item.name

//        else if (item is SpecificPokemonResponse) {
//            Glide.with(context)
//                .load(item.getImageUrl())
//                .apply(requestOptions)
//                .into(holder.cardImage)
//
//            holder.cardTitle.text = item.getName()
//
//            val abilities = mapPokemonAbility(item.abilities)
//            val types = mapPokemonTypes(item.types)
//            val forms = mapPokemonForms(item.forms)
//
//            holder.cardAttributes?.text =
//                "height: ${item.height}\n" +
//                        "base experience: ${item.baseXp}\n" +
//                        "weight: ${item.weight}\n" +
//                        "[abilities:${abilities}]\n" +
//                        "[types: ${types}]" +
//                        "[forms: ${forms}]"
//        }
    }

//    private fun mapPokemonAbility(abilities: List<Abilities>): String {
//        var pokemonAbilities = ""
//
//        for (slot in abilities) {
//            pokemonAbilities += "\nslot: ${slot.slotNumber}, ability: ${slot.ability.name}"
//        }
//
//        return pokemonAbilities
//    }
//
//    private fun mapPokemonTypes(types: List<Types>): String {
//        var pokemonTypes = ""
//
//        for (singleType in types) {
//            pokemonTypes += "\n${singleType.type.name}"
//        }
//
//        return pokemonTypes
//    }
//
//    private fun mapPokemonForms(forms: List<Forms>): String {
//        var pokemonForms = ""
//
//        for (singleForm in forms) {
//            pokemonForms += "\n${singleForm.name}"
//        }
//
//        return pokemonForms
//    }

    override fun getItemCount(): Int = listPokemons.size
}
