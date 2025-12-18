package com.trios2025dej.androidapp4.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trios2025dej.androidapp4.adapters.MenuAdapter
import com.trios2025dej.androidapp4.data.MenuRepository
import com.trios2025dej.androidapp4.databinding.FragmentFeaturedBinding
import com.trios2025dej.androidapp4.models.MenuItem
import com.trios2025dej.androidapp4.util.CartManager
import com.trios2025dej.androidapp4.util.FavoritesManager

class FeaturedFragment : Fragment() {

    private var _binding: FragmentFeaturedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFeaturedBinding.inflate(inflater, container, false)

        // ⭐ Featured = first 3 menu items
        val featuredItems: List<MenuItem> =
            MenuRepository.getAllItems().take(3)

        binding.recyclerFeatured.layoutManager =
            LinearLayoutManager(requireContext())

        binding.recyclerFeatured.adapter =
            MenuAdapter(featuredItems) { item ->
                CartManager.addToCart(item)
                FavoritesManager.addFavorite(requireContext(), item)
            }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
