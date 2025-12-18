package com.trios2025dej.androidapp4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trios2025dej.androidapp4.databinding.ActivityMainBinding
import com.trios2025dej.androidapp4.fragments.FeaturedFragment
import com.trios2025dej.androidapp4.fragments.HomeFragment



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1️⃣ Inflate layout FIRST
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2️⃣ Load fragment AFTER layout exists
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // 3️⃣ Your existing button logic
        binding.btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        binding.btnCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        binding.btnLocation.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }
    }
}
