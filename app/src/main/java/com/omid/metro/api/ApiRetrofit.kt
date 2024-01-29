package com.omid.metro.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRetrofit {
    val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://flutterapps.ir/apps/metro/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}