package com.nisaefendioglu.recentearthquakes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nisaefendioglu.recentearthquakes.R
import com.nisaefendioglu.recentearthquakes.fragment.Earthquake
import com.nisaefendioglu.recentearthquakes.fragment.InfoFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val info= InfoFragment()
        val earthquake = Earthquake()
        //val maps = MapFragment()

        setCurrentFragment(earthquake)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.infoFragment ->setCurrentFragment(info)
                R.id.earthquakeFragment ->setCurrentFragment(earthquake)
             //   R.id.mapsFragment->setCurrentFragment(maps)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}