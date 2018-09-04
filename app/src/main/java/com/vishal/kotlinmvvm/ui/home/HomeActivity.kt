package com.vishal.kotlinmvvm.ui.home

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View

import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.data.model.Model
import com.vishal.kotlinmvvm.databinding.ActivityHomeBinding
import com.vishal.kotlinmvvm.ui.base.BaseActivity
import com.vishal.kotlinmvvm.ui.home.home.HomeFragment
import com.vishal.kotlinmvvm.ui.home.list.ListFragment
import com.vishal.kotlinmvvm.util.isSlideDrawerRequired
import com.vishal.kotlinmvvm.util.isTabRequired
import kotlinx.android.synthetic.main.content_home.view.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeNavigator, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    lateinit var viewModel: HomeViewModel
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialise()

        slideDrawer()
        tab()
    }

    private fun initialise() {
        viewModel = ViewModelProviders.of(this, homeViewModelFactory).get(HomeViewModel::class.java)
        viewModel.mNavigator = this

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }

    // Navigation Drawer shown based on the value isSlideDrawerRequired
    private fun slideDrawer() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (isSlideDrawerRequired) {
            val toggle = ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string
                    .navigation_drawer_close)
            drawer.addDrawerListener(toggle)
            toggle.syncState()
            val navigationView = findViewById(R.id.nav_view) as NavigationView
            navigationView.setNavigationItemSelectedListener(this)
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            navigationView.getMenu().getItem(0).setChecked(true);
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.frame_container, HomeFragment()).commit()
            updateToolbarHeading("Import")
            // Way to access ID's of include tags
            binding.includeHome!!.includeContent!!.frame_container!!.visibility = View.VISIBLE
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            binding.includeHome!!.includeContent!!.frame_container!!.visibility = View.GONE
        }
    }


    // Tabs
    lateinit var pagerAdapter: PagerAdapter

    private fun tab() {
        if (isTabRequired) {
            binding.includeHome!!.includeContent!!.tabs.setupWithViewPager(binding.includeHome!!.includeContent!!.view_pager)
            pagerAdapter = PagerAdapter(supportFragmentManager)
            pagerAdapter.addFragment(HomeFragment(), "Camera")
            pagerAdapter.addFragment(ListFragment(), "Gallery")
            pagerAdapter.addFragment(HomeFragment(), "Slide Show")
            pagerAdapter.addFragment(HomeFragment(), "Tools")
            binding.includeHome!!.includeContent!!.view_pager.adapter = pagerAdapter
            updateToolbarHeading(pagerAdapter.getPageTitle(0).toString())
            binding.includeHome!!.includeContent!!.view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    updateToolbarHeading(pagerAdapter.getPageTitle(position).toString())
                }

                override fun onPageSelected(position: Int) {
                }
            })
            binding.includeHome!!.includeContent!!.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_menu_camera).setText("");
            binding.includeHome!!.includeContent!!.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_menu_gallery).setText("");
            binding.includeHome!!.includeContent!!.tabs.getTabAt(2)!!.setIcon(R.drawable.ic_menu_slideshow).setText("");
            binding.includeHome!!.includeContent!!.tabs.getTabAt(3)!!.setIcon(R.drawable.ic_menu_manage).setText("");
            binding.includeHome!!.includeContent!!.rel_tab.visibility = View.VISIBLE
        } else {
            binding.includeHome!!.includeContent!!.rel_tab.visibility = View.GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var fragment: Fragment? = null;
        var tool_bar_title = ""
        if (id == R.id.nav_camera) {
            fragment = HomeFragment();
            tool_bar_title = "Camera"
        } else if (id == R.id.nav_gallery) {
            fragment = ListFragment();
            tool_bar_title = "Gallery"
        } else if (id == R.id.nav_slideshow) {
            fragment = HomeFragment();
            tool_bar_title = "Slide Show"
        } else if (id == R.id.nav_manage) {
            fragment = HomeFragment();
            tool_bar_title = "Tools"
        }
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)

        Handler().postDelayed(Runnable {
            if (fragment != null) {
                updateToolbarHeading(tool_bar_title)
                val ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.frame_container, fragment).commit()
            }
        }, 300)

        return true
    }

    private fun callApi() {
        viewModel.callApi()
    }

    override fun openHomeScreen(model: Model) {
//        showSnackBar(constraint_root, model.ip)
    }

}

