package com.piton.pokemodule.managers

import android.content.Context
import com.piton.pokemodule.PokemonApplication

object PokemonManager {
    class Builder {
        lateinit var context: Context

        fun build() {
            PokemonApplication.context = context
        }

        fun withContext(context: Context): Builder {
            this.context = context
            return this
        }
    }
}