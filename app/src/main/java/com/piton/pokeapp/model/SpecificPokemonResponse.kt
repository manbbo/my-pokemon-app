package com.piton.pokeapp.model

import com.google.gson.annotations.SerializedName

data class SpecificPokemonResponse(
    @SerializedName("abilities")
    val abilities: List<Abilities>,
    @SerializedName("past_types")
    val pastTypes: List<Types>? = null,
    @SerializedName("types")
    val types: List<Types>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("base_experience")
    val baseXp: Int,
    @SerializedName("id")
    val pokemonId: Int,
    @SerializedName("weight")
    val weight: Int
)

data class Abilities(
    @SerializedName("ability")
    val ability: Ability,
    @SerializedName("slot")
    val slotNumber: Int
)

data class Ability (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class Types(
    @SerializedName("slot")
    val slotNumber: Int,
    @SerializedName("type")
    val type: List<Type>
)

data class Type(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
