package com.nisaefendioglu.recentearthquakes.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nisaefendioglu.recentearthquakes.R
import com.nisaefendioglu.recentearthquakes.adapter.EarthquakeAdapter
import com.nisaefendioglu.recentearthquakes.model.EarthquakeResponse
import com.nisaefendioglu.recentearthquakes.service.ApiClient
import kotlinx.android.synthetic.main.earthquake.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Earthquake : Fragment(R.layout.earthquake) {

    lateinit var placeAdapter: EarthquakeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = requireActivity().findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(context)
        placeAdapter = EarthquakeAdapter()
        recyclerview.adapter = placeAdapter
        getData()
    }

    private fun getData() {

        ApiClient.apiService.getEarthquakes().enqueue(object :
            Callback<EarthquakeResponse> {
            override fun onFailure(call: Call<EarthquakeResponse>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<EarthquakeResponse>,
                response: Response<EarthquakeResponse>
            ) {
                placeAdapter.setList(response.body()?.result ?: emptyList())
                placeAdapter.notifyDataSetChanged()
            }

        })

    }

}