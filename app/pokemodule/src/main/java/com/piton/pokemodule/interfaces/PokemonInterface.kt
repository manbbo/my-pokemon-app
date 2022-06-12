package com.piton.pokemodule.interfaces

import android.widget.ImageView
import android.widget.TextView

interface PokemonInterface {
    var imageView: ImageView
    var titleView: TextView
    var attributesView: TextView?
    var pokemonId: Int
    var url: String
}