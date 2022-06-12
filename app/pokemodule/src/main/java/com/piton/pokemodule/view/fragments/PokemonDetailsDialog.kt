package com.piton.pokemodule.view.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.piton.pokemodule.PokemonApplication
import com.piton.pokemodule.databinding.FragmentPokemonCardBackBinding
import com.piton.pokemodule.interfaces.PokemonInterface
import com.piton.pokemodule.model.Abilities
import com.piton.pokemodule.model.Forms
import com.piton.pokemodule.model.SpecificPokemonResponse
import com.piton.pokemodule.model.Types
import com.piton.pokemodule.viewmodel.PokemonSpecificViewModel

class PokemonDetailsDialog private constructor() : DialogFragment(), PokemonInterface {
    lateinit var _binding: FragmentPokemonCardBackBinding
    private val binding get() = _binding!!

    override var imageView: ImageView = binding.cardImageFlipped
    override var titleView: TextView = binding.cardTitleFlipped
    override var attributesView: TextView? = binding.cardAttributesFlipped
    override var pokemonId: Long = 0
    override var url: String = ""
    private lateinit var closeBt: ImageButton

    lateinit var viewModel: PokemonSpecificViewModel
    lateinit var pokemon: SpecificPokemonResponse

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonCardBackBinding
            .inflate(inflater, container, false)

        this.pokemonId = pokeId
        closeBt = _binding.closeBt
        clickAction()

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        getSpecificPokemonStatus()
        setPokemonData()
    }

    private fun getSpecificPokemonStatus() {
        viewModel.getPokemonById(pokemonId)

        viewModel.observable.observe(
            this,
            {
                pokemon = it
            }
        )
    }

    private val spinner = CircularProgressDrawable(
        PokemonApplication.getAppContext()
    ).apply {
        strokeCap = Paint.Cap.ROUND
        centerRadius = 40f
        strokeWidth = 15f
        start()
    }

    private fun setPokemonData() {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(spinner)
        requestOptions.fallback(spinner)
        requestOptions.error(spinner)

        Glide.with(context)
            .load(pokemon.getImageUrl())
            .apply(requestOptions)
            .into(imageView)

        titleView.text = pokemon.getName()

        val abilities = mapPokemonAbility(pokemon.abilities)
        val types = mapPokemonTypes(pokemon.types)
        val forms = mapPokemonForms(pokemon.forms)

        attributesView?.text =
            "height: ${pokemon.height}\n" +
                    "base experience: ${pokemon.baseXp}\n" +
                    "weight: ${pokemon.weight}\n" +
                    "[abilities:${abilities}]\n" +
                    "[types: ${types}]" +
                    "[forms: ${forms}]"
    }

    private fun mapPokemonAbility(abilities: List<Abilities>): String {
        var pokemonAbilities = ""

        for (slot in abilities) {
            pokemonAbilities += "\nslot: ${slot.slotNumber}, ability: ${slot.ability.name}"
        }

        return pokemonAbilities
    }

    private fun mapPokemonTypes(types: List<Types>): String {
        var pokemonTypes = ""

        for (singleType in types) {
            pokemonTypes += "\n${singleType.type.name}"
        }

        return pokemonTypes
    }

    private fun mapPokemonForms(forms: List<Forms>): String {
        var pokemonForms = ""

        for (singleForm in forms) {
            pokemonForms += "\n${singleForm.name}"
        }

        return pokemonForms
    }

    private fun clickAction() {
        closeBt.setOnClickListener {
            dialog?.dismiss()
        }
    }

    companion object {
        private var pokeId: Long = 0

        fun newDialog(
            pokeId: Long
        ): AlertDialog {
            this.pokeId = pokeId

            return AlertDialog.Builder(PokemonApplication.getAppContext())
                .create()
        }
    }
}