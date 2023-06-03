package com.nisaefendioglu.recentearthquakes.model

import com.google.gson.annotations.SerializedName

data class EarthquakeModelItem(

    @SerializedName("date")
    val date: String? = null,

	@SerializedName("title")
    val title: String? = null,

	@SerializedName("mag")
    val mag: Double? = null,

	@SerializedName("depth")
    val depth: Double? = null

)