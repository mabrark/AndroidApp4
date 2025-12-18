package com.trios2025dej.androidapp4.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trios2025dej.androidapp4.adapters.MenuAdapter
import com.trios2025dej.androidapp4.data.MenuRepository
import com.trios2025dej.androidapp4.databinding.FragmentMenuBinding
import com.trios2025dej.androidapp4.util.FavoritesManager

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        // RecyclerView setup
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        // Adapter with Favorites support
        binding.recyclerView.adapter =
            MenuAdapter(MenuRepository.getAllItems()) { item ->
                FavoritesManager.addFavorite(requireContext(), item)
                Toast.makeText(
                    requireContext(),
                    "Added to Favorites ❤️",
                    Toast.LENGTH_SHORT
                ).show()
            }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
