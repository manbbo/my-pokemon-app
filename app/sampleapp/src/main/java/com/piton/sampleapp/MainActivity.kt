package com.piton.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.piton.pokemodule.managers.PokemonManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PokemonManager.Builder()
                .withContext(applicationContext)
                .build()
    }
}