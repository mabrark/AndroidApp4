package com.trios2025dej.androidapp4.util

import com.trios2025dej.androidapp4.models.MenuItem

object CartManager {

    private val cartItems = mutableListOf<MenuItem>()

    fun addToCart(item: MenuItem) {
        cartItems.add(item)
    }

    fun removeFromCart(item: MenuItem) {
        cartItems.remove(item)
    }

    fun clearCart() {
        cartItems.clear()
    }

    // ✅ EXPLICIT RETURN TYPE (THIS FIXES YOUR ERROR)
    fun getCartItems(): List<MenuItem> {
        return cartItems
    }
}
