package com.piton.pokemodule.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.piton.pokemodule.PokemonApplication
import com.piton.pokemodule.R
import com.piton.pokemodule.adapters.PokemonListAdapter
import com.piton.pokemodule.databinding.FragmentPokemonListBinding
import com.piton.pokemodule.viewmodel.PokemonShowcaseViewModel

class PokemonsListFragment: Fragment() {
    lateinit var _binding: FragmentPokemonListBinding
    private val binding get() = _binding!!

    val listView: ListView = binding.pokemonList

    lateinit var allViewModel: PokemonShowcaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allViewModel = PokemonApplication().getPokemonShowcaseViewModel()

        getAllPokemonsList()

        listView.adapter = getAllPokemonsList()
    }

    fun getAllPokemonsList(): PokemonListAdapter {
        allViewModel.getAllPokemons()
        lateinit var adapter: PokemonListAdapter
        allViewModel.allObservable.observe(
            this,
            {
                adapter = PokemonListAdapter(
                    context = binding.root.context,
                    listPokemons = it,
                    layoutId = R.layout.fragment_pokemon_card_front
                )
            }
        )

        return adapter
    }
}
