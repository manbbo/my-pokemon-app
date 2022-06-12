package com.piton.pokemodule

import android.app.Application
import android.content.Context
import com.piton.pokemodule.api.PokemonClient
import com.piton.pokemodule.factories.PokemonShowcaseViewModelFactory
import com.piton.pokemodule.factories.PokemonSpecificViewModelFactory
import com.piton.pokemodule.interactors.PokemonShowcaseInteractor
import com.piton.pokemodule.interactors.PokemonSpecificInteractor
import com.piton.pokemodule.interfaces.Api
import com.piton.pokemodule.viewmodel.PokemonShowcaseViewModel
import com.piton.pokemodule.viewmodel.PokemonSpecificViewModel

class PokemonApplication: Application() {
    private val api = PokemonClient().api(Api::class.java)

    private val pokemonSpecificInteractor = PokemonSpecificInteractor(api)
    private val pokemonSpecificViewModel: PokemonSpecificViewModel by lazy {
        PokemonSpecificViewModelFactory(pokemonSpecificInteractor)
            .create(PokemonSpecificViewModel::class.java)
    }

    private val pokemonShowcaseInteractor = PokemonShowcaseInteractor(api)
    private val pokemonShowcaseViewModel: PokemonShowcaseViewModel by lazy {
        PokemonShowcaseViewModelFactory(pokemonShowcaseInteractor)
            .create(PokemonShowcaseViewModel::class.java)
    }

    internal fun getPokemonSpecificViewModel() = pokemonSpecificViewModel
    internal fun getPokemonShowcaseViewModel() = pokemonShowcaseViewModel

    companion object {
        lateinit var context: Context

        @JvmStatic
        fun getAppContext() = context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}