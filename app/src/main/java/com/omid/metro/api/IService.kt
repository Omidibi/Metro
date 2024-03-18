package com.omid.metro.api

import com.omid.metro.model.models.Lines
import com.omid.metro.model.models.Stations
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {

    @GET("getLines.php")
    fun getLines(): Observable<Lines>

    @POST("getStations.php")
    @FormUrlEncoded
    suspend fun getStations(@Field("id") id: String): Response<Stations>

}