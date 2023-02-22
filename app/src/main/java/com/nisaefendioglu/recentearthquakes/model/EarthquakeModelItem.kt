package com.nisaefendioglu.recentearthquakes.model

import com.google.gson.annotations.SerializedName

data class EarthquakeModelItem(

    @SerializedName("date")
    val date: String? = null,

	@SerializedName("rev")
    val rev: Any? = null,

	@SerializedName("hash2")
    val hash2: String? = null,

	@SerializedName("lng")
    val lng: Double? = null,

	@SerializedName("lokasyon")
    val lokasyon: String? = null,

	@SerializedName("coordinates")
    val coordinates: List<Double?>? = null,

	@SerializedName("title")
    val title: String? = null,

	@SerializedName("date_stamp")
    val dateStamp: String? = null,

	@SerializedName("date_hour")
    val dateHour: String? = null,

	@SerializedName("mag")
    val mag: Double? = null,

	@SerializedName("depth")
    val depth: Double? = null,

	@SerializedName("lat")
    val lat: Double? = null,

	@SerializedName("hash")
    val hash: String? = null,

	@SerializedName("timestamp")
    val timestamp: Int? = null
)