package com.example.healthybudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class menu_navbar : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_navbar)
        loadFragment(Home())
        // definisi widget
        var bottomnav = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomnav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.navigation_home-> {
                    loadFragment(Home())
                    true
                }

                R.id.navigation_tools -> {
                    loadFragment(Tools())
                    true
                }

                R.id.navigation_profile-> {
                    loadFragment(Profile())
                    true
                }

                else -> {false}
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_frame,fragment)
        transaction.commit()
    }
}

