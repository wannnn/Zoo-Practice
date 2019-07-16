package com.example.zoopractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.zoopractice.R
import com.example.zoopractice.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.colorGray)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setContentView(binding.root)

        setUpView()

    }

    private fun setUpView() {
        setSupportActionBar(binding.toolbar)
        navController = findNavController(this, R.id.nav_host_fragment)
        setupActionBarWithNavController(this, navController, drawerLayout)
        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setupWithNavController(binding.navigationView, navController)
        }

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//                binding.drawerLayout.openDrawer(GravityCompat.START)
//                true
//            }
//
//            else -> super.onOptionsItemSelected(item)
//        }
//    }


    fun updateToolbar(title: String) {
        binding.toolbar.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}
