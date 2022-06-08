package com.piton.pokeapp.model

import com.google.gson.annotations.SerializedName

data class AllPokemonsResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
