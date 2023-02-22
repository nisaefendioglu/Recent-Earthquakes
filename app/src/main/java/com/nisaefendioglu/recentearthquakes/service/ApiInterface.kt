package com.nisaefendioglu.recentearthquakes.service

import com.nisaefendioglu.recentearthquakes.model.EarthquakeResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("deprem/kandilli/live")
    fun getEarthquakes(): Call<EarthquakeResponse>
}