package com.desire.ecommercebottomnav

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.desire.ecommercebottomnav.databinding.ActivityMainBinding
import com.desire.ecommercebottomnav.ui.catalog.ProductFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        
        val appBarConfiguration = AppBarConfiguration(
             setOf(
                 R.id.navigation_home, R.id.navigation_catalog, R.id.navigation_chat,R.id.navigation_cart
             )
         )
//         setupActionBarWithNavController(navController, appBarConfiguration)
         navView.setupWithNavController(navController)
    }
}