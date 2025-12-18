package com.trios2025dej.androidapp4.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trios2025dej.androidapp4.adapters.FavoritesAdapter
import com.trios2025dej.androidapp4.databinding.FragmentFavoritesBinding
import com.trios2025dej.androidapp4.util.FavoritesManager

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        val favorites = FavoritesManager.getFavorites(requireContext())

        adapter = FavoritesAdapter(favorites) { item ->
            FavoritesManager.removeFavorite(requireContext(), item)
            Toast.makeText(
                requireContext(),
                "Removed from Favorites ❌",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.recyclerViewFavorites.layoutManager =
            LinearLayoutManager(requireContext())

        binding.recyclerViewFavorites.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
