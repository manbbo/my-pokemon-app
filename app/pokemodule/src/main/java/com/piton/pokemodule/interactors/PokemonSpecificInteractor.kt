package com.piton.pokemodule.interactors

import com.piton.pokemodule.interfaces.Api
import com.piton.pokemodule.model.SpecificPokemonResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonSpecificInteractor(
    val api: Api,
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getPokemonById(id: Long): SpecificPokemonResponse? =
        withContext(dispatcher) {
            api.getSpecificPokemonById(id)
        }

    suspend fun getPokemonByName(name: String): SpecificPokemonResponse? =
        withContext(dispatcher) {
            api.getSpecificPokemonByName(name)
        }
}