package com.example.progettoium.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progettoium.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_frame_layout, HomePage()).commit()
    }
}