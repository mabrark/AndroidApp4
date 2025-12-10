package com.trios2025dej.androidapp3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.trios2025dej.androidapp3.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            MenuItem(1, "Original Blend Coffee", 1.79, R.drawable.coffee),
            MenuItem(2, "Dark Roast Coffee", 1.99, R.drawable.coffee),
            MenuItem(3, "Latte", 3.49, R.drawable.coffee),
            MenuItem(4, "Iced Coffee", 2.49, R.drawable.coffee)
        )

        adapter = MenuAdapter(items) { item ->
            CartManager.addToCart(item)
        }

        binding.recyclerMenu.layoutManager = LinearLayoutManager(this)
        binding.recyclerMenu.adapter = adapter

        binding.btnViewCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}
