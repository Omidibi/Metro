package com.omid.metro.api

import com.omid.metro.model.listener.IListener
import com.omid.metro.model.models.Lines
import com.omid.metro.model.models.Stations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebServiceCaller {
    private val iService = ApiRetrofit.retrofit.create(IService::class.java)

    fun getLines(iListener: IListener<Lines>) {
        iService.getLines().enqueue(object : Callback<Lines> {
            override fun onResponse(call: Call<Lines>, response: Response<Lines>) {
                iListener.onSuccess(call, response.body()!!)
            }

            override fun onFailure(call: Call<Lines>, t: Throwable) {
                iListener.onFailure(call, t, "Error")
            }

        })
    }

    fun getStations(id: String, iListener: IListener<Stations>) {
        iService.getStations(id).enqueue(object : Callback<Stations> {
            override fun onResponse(call: Call<Stations>, response: Response<Stations>) {
                iListener.onSuccess(call, response.body()!!)
            }

            override fun onFailure(call: Call<Stations>, t: Throwable) {
                iListener.onFailure(call, t, "Error")
            }

        })
    }
}