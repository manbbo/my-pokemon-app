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
import com.piton.pokemodule.view.fragments.PokemonDetailsDialog

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
        var cardTitle =
            itemView.findViewById<TextView>(R.id.card_title)

        fun getRootView(): View = itemView
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

        clickAction(
            holder.getRootView(),
            item
        )
    }

    private fun clickAction(rootView: View, pokemon: PokemonShowcaseResponse) {
        rootView.setOnClickListener {
            PokemonDetailsDialog.newDialog(pokemon.getId()).show()
        }
    }

    override fun getItemCount(): Int = listPokemons.size
}
