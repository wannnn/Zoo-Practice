package com.example.zoopractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.zoopractice.databinding.MainActivityBinding
import com.example.zoopractice.main.MainFragment
import com.example.zoopractice.profile.ProfileFragment
import com.example.zoopractice.traffic.TrafficFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
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

    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.navigation_traffic -> {
                if (getCurrentFrag() is TrafficFragment) return@OnNavigationItemSelectedListener false else
                    findNavController(R.id.nav_host_fragment).navigate(NavGraphDirections.actionGlobalTrafficFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_fav -> {
                if (getCurrentFrag() is MainFragment) return@OnNavigationItemSelectedListener false else
                    findNavController(R.id.nav_host_fragment).navigate(NavGraphDirections.actionGlobalMainFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                if (getCurrentFrag() is ProfileFragment) return@OnNavigationItemSelectedListener false else
                    findNavController(R.id.nav_host_fragment).navigate(NavGraphDirections.actionGlobalProfileFragment())
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
        binding.bottomNavView.selectedItemId = R.id.navigation_fav

        appBarConfig = AppBarConfiguration(
            setOf(R.id.trafficFragment, R.id.mainFragment, R.id.profileFragment), drawerLayout
        )

        // toolbar
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfig)
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

        // bottom navigation
        binding.bottomNavView.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
    }

    private fun getCurrentFrag(): Fragment? = (supportFragmentManager.primaryNavigationFragment as NavHostFragment).childFragmentManager.primaryNavigationFragment

    fun updateToolbar(title: String) {
        binding.toolbar.title = title
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
//    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
