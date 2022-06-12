package com.piton.pokemodule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.piton.pokemodule.interactors.PokemonSpecificInteractor
import com.piton.pokemodule.model.SpecificPokemonResponse
import java.lang.Exception
import kotlinx.coroutines.launch

class PokemonSpecificViewModel(
    private val interactor: PokemonSpecificInteractor
) : BaseViewModel() {

    val state = MutableLiveData<SpecificPokemonResponse>()
    val observable: LiveData<SpecificPokemonResponse> = state

    fun getPokemonById(id: Int) {
        launch(interactor.dispatcher) {
            try {
                val response = interactor.getPokemonById(id)
                state.postValue(response)
            } catch (e: Exception) {
                print("${PokemonSpecificViewModel::class.java.name} ${e.stackTrace}")
            }
        }
    }

    fun getPokemonByName(name: String) {
        launch(interactor.dispatcher) {
            try {
                val response = interactor.getPokemonByName(name)
                state.postValue(response)
            } catch (e: Exception) {
                print("${PokemonSpecificViewModel::class.java.name} ${e.stackTrace}")
            }
        }
    }
}