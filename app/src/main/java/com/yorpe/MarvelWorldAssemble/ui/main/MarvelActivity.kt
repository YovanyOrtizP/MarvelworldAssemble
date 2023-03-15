package com.yorpe.MarvelWorldAssemble.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.yorpe.MarvelWorldAssemble.R
import com.yorpe.MarvelWorldAssemble.databinding.ActivityMarvelBinding
import com.yorpe.MarvelWorldAssemble.ui.login.LoginActivity
import com.yorpe.MarvelWorldAssemble.ui.main.viewmodel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarvelBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var navController: NavController
    private lateinit var searchView: SearchView
    private val viewModel: GeneralViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        searchView = binding.svGeneral
        bottomNavigationView = binding.navView


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)


        //val currentSelectedItemIndex = bottomNavigationView.menu.findItem(bottomNavigationView.selectedItemId).order
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                when(navController.currentDestination?.id){
                    R.id.navigation_characters -> {
                        Handler(Looper.getMainLooper()).postDelayed({
                            viewModel.flowCharacters(query)
                        }, 1500)
                    }
                    R.id.navigation_series -> {
                        Handler(Looper.getMainLooper()).postDelayed({
                            viewModel.flowSeries(query)
                        }, 1500)
                    }
                    R.id.navigation_comics -> {
                        Handler(Looper.getMainLooper()).postDelayed({
                            viewModel.flowComics(query)
                        }, 1500)
                    }
                }
                searchView.clearFocus()
                searchView.setQuery("",false)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        binding.signOutButton.setOnClickListener {
            firebaseAuth.signOut()
            logOut()
        }

    }

    private fun logOut() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}

