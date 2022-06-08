package com.note.keepmynote.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.note.keepmynote.R
import com.note.keepmynote.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        if (supportActionBar != null) {
            supportActionBar?.hide()
        }
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_holder) as NavHostFragment
        navController = navHostFragment.navController
        setContentView(binding.root)
    }
}