package com.omid.metro.api

object InitRetrofit {
    val iService: IService = ApiRetrofit.retrofit.create(IService::class.java)
}