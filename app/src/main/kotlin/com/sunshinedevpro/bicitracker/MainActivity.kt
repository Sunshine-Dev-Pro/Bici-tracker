package com.sunshinedevpro.bicitracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.sunshinedevpro.R
import com.sunshinedevpro.bicitracker.ui.MapsFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mMapFragment = MapsFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.mapContainer, mMapFragment)
        fragmentTransaction.commit()
    }
}