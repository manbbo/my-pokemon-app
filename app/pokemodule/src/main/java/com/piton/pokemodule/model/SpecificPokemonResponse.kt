package com.piton.pokemodule.model

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
    val weight: Int,
    @SerializedName("forms")
    val forms: List<Forms>
) {
    fun getName(): String = forms[0].name
    fun getImageUrl() =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/${this.pokemonId}.png"
}

data class Abilities(
    @SerializedName("ability")
    val ability: Ability,
    @SerializedName("slot")
    val slotNumber: Int
)

data class Forms(
    @SerializedName("name")
    val name: String
)

data class Ability(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class Types(
    @SerializedName("type")
    val type: Type
)

data class Type(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
