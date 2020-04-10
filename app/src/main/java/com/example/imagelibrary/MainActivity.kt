package com.example.imagelibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.imagelibrary.Fragments.Login


class MainActivity : AppCompatActivity() {
    lateinit var fragmentManager:FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager=supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.main_layout, Login.newInstance()).addToBackStack(null).commit()


    }
}
