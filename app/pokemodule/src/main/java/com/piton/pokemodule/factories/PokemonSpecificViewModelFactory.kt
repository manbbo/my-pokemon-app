package com.piton.pokemodule.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piton.pokemodule.interactors.PokemonSpecificInteractor
import com.piton.pokemodule.viewmodel.PokemonSpecificViewModel

class PokemonSpecificViewModelFactory(
    private val interactor: PokemonSpecificInteractor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        PokemonSpecificViewModel(interactor) as T
}