package com.nisaefendioglu.recentearthquakes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.nisaefendioglu.recentearthquakes.R
import com.nisaefendioglu.recentearthquakes.databinding.ActivityMainBinding
import com.nisaefendioglu.recentearthquakes.fragment.EarthquakeFragment
import com.nisaefendioglu.recentearthquakes.fragment.InfoFragment
import com.nisaefendioglu.recentearthquakes.fragment.MapsFragment

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val info= InfoFragment()
        val earthquake = EarthquakeFragment()
        val maps = MapsFragment()

        setCurrentFragment(earthquake)
        binding.bottomNavigationView.selectedItemId = R.id.earthquakeFragment
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.infoFragment ->setCurrentFragment(info)
                R.id.earthquakeFragment ->setCurrentFragment(earthquake)
                R.id.mapsFragment->setCurrentFragment(maps)
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