package com.nisaefendioglu.recentearthquakes.model


import com.google.gson.annotations.SerializedName

data class EarthquakeModelItem(
    @SerializedName("boylam")
    val boylam: String,
    @SerializedName("buyukluk")
    val buyukluk: String,
    @SerializedName("derinlik")
    val derinlik: String,
    @SerializedName("enlem")
    val enlem: String,
    @SerializedName("saat")
    val saat: String,
    @SerializedName("sehir")
    val sehir: String,
    @SerializedName("tarih")
    val tarih: String,
    @SerializedName("yer")
    val yer: String
)