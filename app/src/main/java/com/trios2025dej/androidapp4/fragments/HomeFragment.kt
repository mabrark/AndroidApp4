package com.trios2025dej.androidapp4.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trios2025dej.androidapp4.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_nav)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.home_fragment_container, FeaturedFragment())
                .commit()
        }

        bottomNav.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.nav_featured -> FeaturedFragment()
                R.id.nav_menu -> MenuFragment()
                R.id.nav_favorites -> FavoritesFragment()
                else -> FeaturedFragment()
            }

            childFragmentManager.beginTransaction()
                .replace(R.id.home_fragment_container, fragment)
                .commit()

            true
        }

        return view
    }
}
