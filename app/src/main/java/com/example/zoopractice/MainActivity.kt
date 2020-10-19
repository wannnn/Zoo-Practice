package com.example.zoopractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
import com.example.zoopractice.detail.DetailFragment
import com.example.zoopractice.feedback.FeedBackFragment
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

        // Navigation 的 ActionBar 預設進入 Fragment 時上方的 menu 紐會變成一個返回鍵，
        // 要想禁用這個效果可以在他的 Builder 裡放入要保持原樣的 Fragment xml
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
        binding.drawerNavView.setNavigationItemSelectedListener(onDrawerNavItemSelectedListener)

        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, _: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        // bottom navigation
        binding.bottomNavView.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        binding.bottomNavView.selectedItemId = R.id.navigation_fav

        if (getCurrentFrag() is DetailFragment || getCurrentFrag() is FeedBackFragment) {
            binding.bottomNavView.visibility = View.GONE
        } else {
            binding.bottomNavView.visibility = View.VISIBLE
        }
    }

    private fun getCurrentFrag(): Fragment? = supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.primaryNavigationFragment

    fun updateToolbar(title: String) {
        binding.toolbar.title = title
    }

    // 返回鍵觸發時的行為可以依據 AppBarConfiguration 的設定來變化
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
