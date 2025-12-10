package com.trios2025dej.androidapp3

data class CartItem(
    val name: String,
    val price: Double,
    val imageRes: Int,
    var quantity: Int = 1
)
