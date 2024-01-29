package com.omid.metro.api

import com.omid.metro.model.models.Lines
import com.omid.metro.model.models.Stations
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {

    @GET("getLines.php")
    fun getLines(): Call<Lines>

    @POST("getStations.php")
    @FormUrlEncoded
    fun getStations(@Field("id") id: String): Call<Stations>

}