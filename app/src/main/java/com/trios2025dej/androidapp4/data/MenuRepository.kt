package com.trios2025dej.androidapp4.data

import com.trios2025dej.androidapp4.R
import com.trios2025dej.androidapp4.models.MenuItem

object MenuRepository {

    fun getAllItems(): List<MenuItem> {
        return listOf(
            // ☕ Coffee
            MenuItem(
                name = "Original Blend Coffee",
                price = 1.79,
                imageResId = R.drawable.coffee,
                category = "Coffee"
            ),
            MenuItem(
                name = "Dark Roast Coffee",
                price = 1.99,
                imageResId = R.drawable.coffee,
                category = "Coffee"
            ),
            MenuItem(
                name = "Latte",
                price = 3.49,
                imageResId = R.drawable.coffee,
                category = "Coffee"
            ),
            MenuItem(
                name = "Iced Coffee",
                price = 2.49,
                imageResId = R.drawable.coffee,
                category = "Coffee"
            ),

            // 🍩 Donuts
            MenuItem(
                name = "Chocolate Donut",
                price = 1.79,
                imageResId = R.drawable.donut,
                category = "Donut"
            ),

            // 🍳 Breakfast
            MenuItem(
                name = "Breakfast Wrap",
                price = 4.99,
                imageResId = R.drawable.breakfast,
                category = "Breakfast"
            ),

            // 🥪 Sandwiches
            MenuItem(
                name = "Turkey Sandwich",
                price = 6.49,
                imageResId = R.drawable.sandwich,
                category = "Sandwich"
            )
        )
    }
}
