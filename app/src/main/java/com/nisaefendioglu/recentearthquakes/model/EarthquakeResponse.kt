package com.nisaefendioglu.recentearthquakes.model

import com.google.gson.annotations.SerializedName

data class EarthquakeResponse(

	@SerializedName("result")
	val result: List<EarthquakeModelItem?>? = null,

	@SerializedName("status")
	val status: Boolean? = null
)