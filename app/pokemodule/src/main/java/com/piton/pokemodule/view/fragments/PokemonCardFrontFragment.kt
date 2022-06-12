package com.piton.pokemodule.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.piton.pokemodule.databinding.FragmentPokemonCardFrontBinding
import com.piton.pokemodule.interfaces.PokemonInterface
import com.piton.pokemodule.viewmodel.PokemonShowcaseViewModel

class PokemonCardFrontFragment(
    val pokemonViewModel: PokemonShowcaseViewModel
) : Fragment(), PokemonInterface {
    lateinit var _binding: FragmentPokemonCardFrontBinding
    private val binding get() = _binding!!

    override var titleView: TextView = binding.cardTitle
    override var imageView: ImageView = binding.cardImage
    override var attributesView: TextView? = null
    override var pokemonId: Int = 0
    override var url: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonCardFrontBinding
            .inflate(inflater, container, false)
        return binding.root
    }
}