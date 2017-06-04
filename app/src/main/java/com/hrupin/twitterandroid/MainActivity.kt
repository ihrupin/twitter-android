package com.hrupin.twitterandroid

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import butterknife.bindView

import com.hrupin.twitterandroid.fragments.FavoritesFragment
import com.hrupin.twitterandroid.fragments.NearbyFragment
import com.hrupin.twitterandroid.fragments.SearchFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val toolbar: Toolbar by bindView(R.id.toolbar)
    val drawer: DrawerLayout by bindView(R.id.drawer_layout)
    val navigationView: NavigationView by bindView(R.id.nav_view)

    val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Log.i(TAG, "drawer=" + drawer)

        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_search)
        attachFragment(SearchFragment.newInstance(), SearchFragment.FRAGMENT_TAG)
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.nav_search) {
            attachFragment(SearchFragment.newInstance(), SearchFragment.FRAGMENT_TAG)
        } else if (id == R.id.nav_favorites) {
            attachFragment(FavoritesFragment.newInstance(), FavoritesFragment.FRAGMENT_TAG)
        } else if (id == R.id.nav_nearby) {
            attachFragment(NearbyFragment.newInstance(), NearbyFragment.FRAGMENT_TAG)
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun attachFragment(fragment: Fragment?, currentTag : String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        fragmentTransaction.replace(R.id.contentFrame, fragment, currentTag)
        fragmentTransaction.commitAllowingStateLoss()
    }
}
