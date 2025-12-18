package com.trios2025dej.androidapp4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trios2025dej.androidapp4.models.MenuItem
import com.trios2025dej.androidapp4.util.CartManager

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var txtTotal: TextView
    private lateinit var btnClearCart: Button
    private lateinit var btnCheckout: Button
    private lateinit var cartAdapter: CartAdapter

    // 🔹 This list is what the adapter works with
    private lateinit var cartItems: MutableList<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // View bindings
        recyclerView = findViewById(R.id.recyclerViewCart)
        txtTotal = findViewById(R.id.txtCartTotal)
        btnClearCart = findViewById(R.id.btnClearCart)
        btnCheckout = findViewById(R.id.btnCheckout)

        // ✅ Get cart items ONCE and convert to MutableList
        cartItems = CartManager.getCartItems().toMutableList()

        // RecyclerView setup
        recyclerView.layoutManager = LinearLayoutManager(this)

        cartAdapter = CartAdapter(cartItems) {
            updateTotal()
        }



        recyclerView.adapter = cartAdapter

        // Initial total
        updateTotal()

        // Clear cart button
        btnClearCart.setOnClickListener {
            cartItems.clear()
            CartManager.clearCart()
            cartAdapter.notifyDataSetChanged()
            updateTotal()
        }

        // Checkout button
        btnCheckout.setOnClickListener {
            startActivity(Intent(this, OrderConfirmedActivity::class.java))
        }
    }

    // 🔹 Calculates total safely
    private fun updateTotal() {
        val total = cartItems.sumOf { it.price.toDouble() }
        txtTotal.text = "Total: $%.2f".format(total)
    }

}
