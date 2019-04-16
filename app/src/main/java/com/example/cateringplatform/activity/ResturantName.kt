package com.example.cateringplatform.activity

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout

import com.example.cateringplatform.R
import com.example.cateringplatform.fragment.AccountFragment
import com.example.cateringplatform.fragment.OrderHistoryFragment
import com.example.cateringplatform.fragment.ResturantHomeFragment
import com.example.cateringplatform.fragment.SearchFragment

class ResturantName : AppCompatActivity() {

    private var fragmentContainer: FrameLayout? = null
    private var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resturant_name)

        fragmentContainer = findViewById(R.id.fragment_container)
        bottomNavigationView = findViewById(R.id.nav_bottom)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ResturantHomeFragment()).commit()

        bottomNavigationView!!.setOnNavigationItemSelectedListener { menuItem ->
            var selectedFragment: Fragment? = null

            when (menuItem.itemId) {

                R.id.nav_res_home -> selectedFragment = ResturantHomeFragment()

                R.id.nav_res_search -> selectedFragment = SearchFragment()

                R.id.nav_res_history -> selectedFragment = OrderHistoryFragment()

                R.id.nav_res_account -> selectedFragment = AccountFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment!!).commit()

            true
        }
    }
}
