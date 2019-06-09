package com.bravedroid.courify.navigation

import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.bravedroid.courify.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.ref.WeakReference

class BottomNavigationViewListener(private val fragment: WeakReference<Fragment>) :
    BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val mainNavHostFragment =
            fragment.get()?.childFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val mainNavController = mainNavHostFragment.navController

        when (item.itemId) {
            R.id.addFragment -> {
                val introNavController = fragment.get()?.findNavController()
                introNavController?.navigate(R.id.action_mainFragment_to_itemListDialogFragment)
                return false
            }
            else -> {
                val builder = NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
                    .setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim)
                    .setPopEnterAnim(androidx.navigation.ui.R.anim.nav_default_pop_enter_anim)
                    .setPopExitAnim(androidx.navigation.ui.R.anim.nav_default_pop_exit_anim)
                if (item.order and Menu.CATEGORY_SECONDARY == 0) {
                    builder.setPopUpTo(
                        findStartDestination(mainNavController.graph)!!.id,
                        false
                    )
                }
                val options = builder.build()
                try {
                    //a TODO copied from Google provide proper API instead of using Exceptions as Control-Flow.
                    mainNavController.navigate(item.itemId, null, options)
                    return true
                } catch (e: IllegalArgumentException) {
                    return false
                }
            }
        }
    }

    private fun findStartDestination(graph: NavGraph): NavDestination? {
        var startDestination: NavDestination? = graph
        while (startDestination is NavGraph) {
            val parent = startDestination as NavGraph?
            startDestination = parent!!.findNode(parent.startDestination)
        }
        return startDestination
    }
}
