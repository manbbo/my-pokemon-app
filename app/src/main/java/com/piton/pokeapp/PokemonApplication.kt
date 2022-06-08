package com.piton.pokeapp

import android.app.Application
import android.content.Context

class PokemonApplication: Application() {
    companion object {
        lateinit var context: Context
        @JvmStatic
        fun getAppContext() = this.context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}