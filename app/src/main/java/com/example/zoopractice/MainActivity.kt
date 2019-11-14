package com.example.zoopractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.zoopractice.NavGraphDirections
import com.example.zoopractice.R
import com.example.zoopractice.databinding.MainActivityBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration

    private val onDrawerNavItemSelectedListener = NavigationView.OnNavigationItemSelectedListener{
        when (it.itemId) {
            R.id.item_feedback -> {
                findNavController(R.id.nav_host_fragment).navigate(NavGraphDirections.actionGlobalFeedBackFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.colorGray)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setContentView(binding.root)

        navController = findNavController(this, R.id.nav_host_fragment)

        setUpView()

    }

    private fun setUpView() {

        // toolbar
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(this, navController, drawerLayout)
        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setupWithNavController(binding.drawerNavView, navController)
        }

        // drawer
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, _: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        binding.drawerNavView.setNavigationItemSelectedListener(onDrawerNavItemSelectedListener)

    }


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
