package com.piton.pokemodule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.piton.pokemodule.interactors.PokemonShowcaseInteractor
import com.piton.pokemodule.model.PokemonShowcaseResponse
import java.lang.Exception
import kotlinx.coroutines.launch

class PokemonShowcaseViewModel(
    private val interactor: PokemonShowcaseInteractor
) : BaseViewModel() {

    val showcase = MutableLiveData<List<PokemonShowcaseResponse>>()
    val showcaseObservable: LiveData<List<PokemonShowcaseResponse>> = showcase

    val all = MutableLiveData<List<PokemonShowcaseResponse>>()
    val allObservable: LiveData<List<PokemonShowcaseResponse>> = all

    fun getAllPokemons() {
        launch(interactor.dispatcher) {
            try {
                val response = interactor.getAllPokemons()
                showcase.postValue(response)
            } catch (e: Exception) {
                print("${PokemonShowcaseViewModel::class.java.name} ${e.stackTrace}")
            }
        }
    }

    fun getShowcasedPokemons() {
        launch(interactor.dispatcher) {
            try {
                val response = interactor.getShowcasedPokemons()
                all.postValue(response)
            } catch (e: Exception) {
                print("${PokemonShowcaseViewModel::class.java.name} ${e.stackTrace}")
            }
        }
    }
}