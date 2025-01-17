package com.example.mobile_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class UserDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)

        // Initialize Bottom Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set default fragment (Home) on launch
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // Set default fragment (Home) on launch
        loadFragment(HomeFragment())

        // Handle item selection in Bottom Navigation
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_products -> {
                    loadFragment(ProductsFragment())
                    true
                }
                R.id.nav_cart -> {
                    loadFragment(CartFragment())
                    true
                }
                R.id.nav_educational -> {
                    loadFragment(EducationFragment())
                    true
                }
                else -> false
            }
        }


        // Set up the cart icon (button functionality can be added later)
        val btnCart = findViewById<ImageButton>(R.id.btnCart)
        btnCart.setOnClickListener {
            // Future functionality for cart button

        }
    }

    // Load fragments for each navigation item
//    private fun loadFragment(fragment: Fragment) {
        private fun loadFragment(fragment: Fragment) {
            Log.d("Navigation", "Loading fragment: ${fragment::class.java.simpleName}") // Log statement
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}

