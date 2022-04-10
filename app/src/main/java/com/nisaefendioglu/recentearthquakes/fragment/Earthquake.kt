package com.nisaefendioglu.recentearthquakes.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nisaefendioglu.recentearthquakes.R
import com.nisaefendioglu.recentearthquakes.RecyclerAdapter
import com.nisaefendioglu.recentearthquakes.model.EarthquakeModelItem
import com.nisaefendioglu.recentearthquakes.service.ApiClient
import kotlinx.android.synthetic.main.earthquake.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Earthquake : Fragment(R.layout.earthquake) {

    private var listUsers: MutableList<EarthquakeModelItem> = mutableListOf<EarthquakeModelItem>()
    private var adapter: RecyclerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress_bar.visibility = View.VISIBLE

        val recyclerview = requireActivity().findViewById<RecyclerView>(R.id.recyclerview)
        listUsers = mutableListOf()

        recyclerview.layoutManager = LinearLayoutManager(context)
        adapter = RecyclerAdapter(
            requireContext(),
            listUsers
        )
        recyclerview.adapter = adapter
        getUsersData()
    }

    private fun getUsersData() {

        ApiClient.apiService.getEarthquakes().enqueue(object :
            Callback<MutableList<EarthquakeModelItem>> {
            override fun onFailure(call: Call<MutableList<EarthquakeModelItem>>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<EarthquakeModelItem>>,
                response: Response<MutableList<EarthquakeModelItem>>
            ) {
                val usersResponse = response.body()
                listUsers.clear()
                usersResponse?.let { listUsers.addAll(it) }
                adapter?.notifyDataSetChanged()
                progress_bar.visibility = View.GONE

            }

        })

    }

}