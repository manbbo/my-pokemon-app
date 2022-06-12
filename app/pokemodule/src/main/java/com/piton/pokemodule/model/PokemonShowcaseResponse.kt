package com.piton.pokemodule.model

import com.google.gson.annotations.SerializedName

data class PokemonShowcaseResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) {
    fun getImageUrl(): String
        = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getId()}.png"

    fun getId(): Long {
        var getStrings = url.split("/")
            .toMutableList()

        getStrings.removeIf { it.isNullOrBlank() || it.isNullOrEmpty() }

        return getStrings.last().toLong()
    }
}
