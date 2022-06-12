package com.piton.pokemodule.interfaces

import com.piton.pokemodule.model.PokemonShowcaseResponse
import com.piton.pokemodule.model.SpecificPokemonResponse
import retrofit2.http.GET

interface Api {
    @GET("/pokemon?limit={limit}offset={offset}")
    fun getAllPokemons(
        limit: Long = 100000,
        offset: Long = 5
    ): List<PokemonShowcaseResponse>

    @GET("/pokemon/{name}")
    fun getSpecificPokemonByName(
        name: String
    ): SpecificPokemonResponse

    @GET("/pokemon/{pokemonId}")
    fun getSpecificPokemonById(
        pokemonId: Long
    ): SpecificPokemonResponse
}