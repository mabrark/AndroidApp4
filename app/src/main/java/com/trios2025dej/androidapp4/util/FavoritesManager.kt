package com.trios2025dej.androidapp4.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.trios2025dej.androidapp4.models.MenuItem

object FavoritesManager {

    private const val PREFS_NAME = "favorites_prefs"
    private const val KEY_FAVORITES = "favorites"

    fun getFavorites(context: Context): MutableList<MenuItem> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_FAVORITES, null) ?: return mutableListOf()

        val type = object : TypeToken<MutableList<MenuItem>>() {}.type
        return Gson().fromJson(json, type)
    }

    fun addFavorite(context: Context, item: MenuItem) {
        val favorites = getFavorites(context)

        if (favorites.none { it.name == item.name }) {
            favorites.add(item)
            save(context, favorites)
        }
    }

    fun removeFavorite(context: Context, item: MenuItem) {
        val favorites = getFavorites(context)
        favorites.removeAll { it.name == item.name }
        save(context, favorites)
    }

    private fun save(context: Context, favorites: List<MenuItem>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit()
            .putString(KEY_FAVORITES, Gson().toJson(favorites))
            .apply()
    }
}
