package com.trios2025dej.androidapp4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.trios2025dej.androidapp4.adapters.MenuAdapter
import com.trios2025dej.androidapp4.databinding.ActivityMenuBinding
import com.trios2025dej.androidapp4.models.MenuItem
import com.trios2025dej.androidapp4.util.CartManager

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            MenuItem("Original Blend Coffee", 1.79, R.drawable.coffee, "Coffee"),
            MenuItem("Dark Roast Coffee", 1.99, R.drawable.coffee, "Coffee"),
            MenuItem("Latte", 3.49, R.drawable.coffee, "Coffee"),
            MenuItem("Iced Coffee", 2.49, R.drawable.coffee, "Coffee")
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
