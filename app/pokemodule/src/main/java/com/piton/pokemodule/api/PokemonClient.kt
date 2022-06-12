package com.piton.pokemodule.api

import retrofit2.Retrofit

class PokemonClient(
    private val baseUrl: String = "https://pokeapi.co/api/v2"
) {
    fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .build()
    }

    fun <T> api(apiInterface: Class<T>): T = getClient().create(apiInterface)
}