package com.example.kidya_example

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.core.view.isGone
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.kidya_example.util.NavigationUIHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toggle: ActionBarDrawerToggle

    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    // private  var drawer: DrawerLayout
    private var navigationView: NavigationView? = null
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var contentView: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        initializeDefaultFragment(savedInstanceState, 0)

        setSupportActionBar(toolbar)
//        toolbar.setTitle("")
//        toolbar.navigationIcon = null
        // getSupportActionBar()!!.setDisplayHomeAsUpEnabled(false)
        //    getSupportActionBar()!!.setHomeButtonEnabled(false)





        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
//        toolbar.navigationIcon?.setVisible(false, false)
        toolbar.navigationIcon = null
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        bottomNavView = findViewById(R.id.bottom_nav_view)
        // navigationView = findViewById(R.id.navi)
        // supportActionBar?.setDisplayHomeAsUpEnabled(false)
        //  supportActionBar?.setHomeButtonEnabled(false)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_slideshow,
                R.id.nav_basket,
                R.id.nav_favourites,
                R.id.nav_grid,
                R.id.nav_message,
                R.id.nav_account
            ), drawerLayout
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            when (destination.id) {
                R.id.nav_basket -> toolbar.isGone = true
                R.id.nav_favourites -> toolbar.isGone = true
                R.id.nav_skitka_back -> toolbar.isGone = true
                R.id.nav_account -> toolbar.isGone = true
                R.id.nav_message -> toolbar.isGone = true
                R.id.nav_home -> toolbar.isGone = false
                R.id.nav_grid -> toolbar.isGone = false
                else -> supportActionBar?.show()

            }
        }

        //Toolbar image button
        imageNews.setOnClickListener {
            Log.d("ttt", "imageNews")
            navController.navigate(R.id.nav_news_back_list)
        }
        imageBell.setOnClickListener {
            Log.d("ttt", "imageBell")
            navController.navigate(R.id.nav_bell)
        }


        navView.setNavigationItemSelectedListener {
            Log.d("ttt", "$it")

            when (it.title) {
                "Мой данные" -> {
                    Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.nav_account)
                    drawerLayout.close()
                }
                "Мои заказы" -> Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                "Избранные" -> Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                "Скидки" -> Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                "Акции" -> Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                "Сообщения" -> {
                    Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.nav_message)
                    drawerLayout.close()
                }
            }

            false
        }

        bottomNavView.setOnNavigationItemSelectedListener { item: MenuItem ->
            val builder = NavOptions.Builder()
                .setLaunchSingleTop(true)

            when (item.title) {
                "_" -> drawerLayout.openDrawer(GravityCompat.START)

                "favourite" -> {
                    navController.navigate(R.id.nav_favourites)
                }
                "add" -> {
                    navController.navigate(R.id.nav_basket)
                }
                "nav_home" -> {
                    navController.navigate(R.id.nav_home)
                }
                "grid" -> {
//                    navController.popBackStack()
                    navController.navigate(R.id.nav_grid)
                }

                else -> {
                    navController.navigate(R.id.nav_home)
                }
            }

            NavigationUIHelper.onNavDestinationSelected(item, navController, builder)
            true
        }
    }


    override fun onBackPressed() {
        if (bottomNavView.selectedItemId == R.id.nav_home) {
            super.onBackPressed()
        } else {
            bottomNavView.selectedItemId = R.id.nav_home
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)


        // Associate searchable configuration with the SearchView
//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        (menu.findItem(R.id.search).actionView as SearchView).apply {
//            setSearchableInfo(searchManager.getSearchableInfo(componentName))
//        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}