package com.nisaefendioglu.recentearthquakes.service

import com.nisaefendioglu.recentearthquakes.model.EarthquakeModelItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api")
    fun getEarthquakes() : Call<MutableList<EarthquakeModelItem>>
}