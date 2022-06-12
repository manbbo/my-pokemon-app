package com.piton.pokemodule.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.piton.pokemodule.databinding.FragmentPokemonCardBackBinding
import com.piton.pokemodule.interfaces.PokemonInterface
import com.piton.pokemodule.viewmodel.PokemonShowcaseViewModel

class PokemonCardBackFragment(
    val pokemonViewModel: PokemonShowcaseViewModel
) : DialogFragment(), PokemonInterface {
    lateinit var _binding: FragmentPokemonCardBackBinding
    private val binding get() = _binding!!

    override var imageView: ImageView = binding.cardImageFlipped
    override var titleView: TextView = binding.cardTitleFlipped
    override var attributesView: TextView? = binding.cardAttributesFlipped
    override var pokemonId: Int = 0
    override var url: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonCardBackBinding
            .inflate(inflater, container, false)
        return binding.root
    }
}