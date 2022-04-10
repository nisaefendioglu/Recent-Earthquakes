package com.nisaefendioglu.recentearthquakes.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

                private const val BASE_URL: String = "https://turkiyedepremapi.herokuapp.com/"

                private val gson : Gson by lazy {
                        GsonBuilder().setLenient().create()
                }

                private val retrofit : Retrofit by lazy {
                        Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .build()
                }

                val apiService :  ApiInterface by lazy{
                        retrofit.create(ApiInterface::class.java)
                }

        }
