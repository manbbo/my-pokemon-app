package com.piton.pokemodule.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.piton.pokemodule.PokemonApplication
import com.piton.pokemodule.R
import com.piton.pokemodule.adapters.PokemonShowcaseAdapter
import com.piton.pokemodule.databinding.FragmentPokemonShowcaseBinding
import com.piton.pokemodule.viewmodel.PokemonShowcaseViewModel

class PokemonsShowcaseFragment: Fragment() {
    lateinit var _binding: FragmentPokemonShowcaseBinding
    private val binding get() = _binding!!

    val recyclerView: RecyclerView = binding.pokemonShowcase

    lateinit var showcasedViewModel: PokemonShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonShowcaseBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showcasedViewModel = PokemonApplication().getPokemonShowcaseViewModel()

        recyclerView.adapter = getShowcasedPokemonsList()

    }

    fun getShowcasedPokemonsList(): PokemonShowcaseAdapter {
        showcasedViewModel.getShowcasedPokemons()

        lateinit var adapter: PokemonShowcaseAdapter

        showcasedViewModel.allObservable.observe(
            this,
            {
                adapter = PokemonShowcaseAdapter(
                    context = PokemonApplication.getAppContext(),
                    listPokemons = it,
                    layoutId = R.layout.fragment_pokemon_card_front
                )
            }
        )

        return adapter
    }
}
