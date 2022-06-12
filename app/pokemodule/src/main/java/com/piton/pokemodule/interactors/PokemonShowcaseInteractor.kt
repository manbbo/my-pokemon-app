package com.piton.pokemodule.interactors

import com.piton.pokemodule.interfaces.Api
import com.piton.pokemodule.model.PokemonShowcaseResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonShowcaseInteractor(
    val api: Api,
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getShowcasedPokemons(): List<PokemonShowcaseResponse>? =
        withContext(dispatcher) {
            api.getAllPokemons(limit = 5, offset = 0)
        }

    suspend fun getAllPokemons(): List<PokemonShowcaseResponse>? =
        withContext(dispatcher) {
            api.getAllPokemons()
        }
}