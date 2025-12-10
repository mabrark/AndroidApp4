package com.trios2025dej.androidapp3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trios2025dej.androidapp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- Existing Tim Hortons navigation ---
        binding.btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        binding.btnCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        // --- NEW GPS FEATURES ---

        binding.btnLocation.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }

        binding.btnCompass.setOnClickListener {
            startActivity(Intent(this, CompassActivity::class.java))
        }

        binding.btnSearchLocation.setOnClickListener {
            startActivity(Intent(this, SearchLocationActivity::class.java))
        }

        binding.btnOpenMap.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}
