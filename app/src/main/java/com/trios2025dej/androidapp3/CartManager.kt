package com.trios2025dej.androidapp3

object CartManager {

    val items = mutableListOf<CartItem>()

    fun addToCart(item: MenuItem) {
        // Check if item already exists
        val existing = items.find { it.name == item.name }

        if (existing != null) {
            existing.quantity += 1
        } else {
            items.add(
                CartItem(
                    name = item.name,
                    price = item.price,
                    imageRes = item.imageRes,
                    quantity = 1
                )
            )
        }
    }

    fun clearCart() {
        items.clear()
    }

    fun getTotalPrice(): Double {
        return items.sumOf { it.price * it.quantity }
    }
}
