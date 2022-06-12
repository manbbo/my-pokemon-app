package com.piton.pokemodule.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.piton.pokemodule.R
import com.piton.pokemodule.model.PokemonShowcaseResponse

class PokemonListAdapter(
    val context: Context,
    private val listPokemons: List<PokemonShowcaseResponse>,
    @LayoutRes
    private val layoutId: Int
) : BaseAdapter() {

    private val spinner = CircularProgressDrawable(context).apply {
        strokeCap = Paint.Cap.ROUND
        centerRadius = 40f
        strokeWidth = 15f
        start()
    }

    override fun getCount(): Int = listPokemons.size

    override fun getItem(p0: Int): Any = listPokemons[p0]

    override fun getItemId(p0: Int): Long = listPokemons[p0].getId()

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var view = convertView ?: LayoutInflater.from(context).inflate(
            layoutId,
            parent,
            false
        )

        var cardImage =
            view.findViewById<ImageView>(R.id.card_image)
        var cardTitle =
            view.findViewById<TextView>(R.id.card_title)

        val requestOptions = RequestOptions()
        requestOptions.placeholder(spinner)
        requestOptions.fallback(spinner)
        requestOptions.error(spinner)

        var item = listPokemons[position]

        Glide.with(context)
            .load(item.getImageUrl())
            .apply(requestOptions)
            .into(cardImage)

        cardTitle.text = item.name

        return view
    }
}
