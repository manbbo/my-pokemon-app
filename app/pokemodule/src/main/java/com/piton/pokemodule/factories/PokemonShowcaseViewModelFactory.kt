package com.piton.pokemodule.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piton.pokemodule.interactors.PokemonShowcaseInteractor
import com.piton.pokemodule.viewmodel.PokemonShowcaseViewModel

class PokemonShowcaseViewModelFactory(
    private val interactor: PokemonShowcaseInteractor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        PokemonShowcaseViewModel(interactor) as T
}