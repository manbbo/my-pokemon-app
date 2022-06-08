package com.piton.pokeapp.interfaces

import com.piton.pokeapp.model.AllPokemonsResponse
import com.piton.pokeapp.model.SpecificPokemonResponse
import retrofit2.http.GET

interface Api {
    @GET("/pokemon?limit={limit}offset={offset}")
    fun getAllPokemons(
        limit: Long,
        offset: Long
    ): AllPokemonsResponse

    @GET("/pokemon/{name}")
    fun getSpecificPokemonByName(
        name: String
    ): SpecificPokemonResponse

    @GET("/pokemon/{pokemonId}")
    fun getSpecificPokemonById(
        pokemonId: Int
    ): SpecificPokemonResponse
}