package com.example.progettoium.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.progettoium.view.navFragment.FirstFragment
import com.example.progettoium.R
import com.example.progettoium.view.navFragment.SecondFragment
import com.example.progettoium.databinding.ActivityMainBinding
import me.ibrahimsn.lib.SmoothBottomBar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomBar = findViewById<SmoothBottomBar>(R.id.bottomBar)

        bottomBar.onItemSelected = {

            if(it == 0) navigateTo(HomePage())
            if(it == 1){
                navigateTo(FirstFragment())
            }
            if(it == 2){
                navigateTo(SecondFragment())
            }

        }

        bottomBar.onItemReselected = {
            println(it)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_frame_layout, HomePage()).commit()
    }

    private fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_frame_layout, fragment).commit()
    }


}