package com.trios2025dej.androidapp4.models

import java.io.Serializable

data class MenuItem(
    val name: String,
    val price: Double,
    val imageResId: Int,
    val category: String
) : Serializable
