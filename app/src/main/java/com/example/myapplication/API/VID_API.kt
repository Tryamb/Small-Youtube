package com.example.myapplication.API

import com.example.myapplication.model2.VideoStats
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VID_API {
    @GET("videos")
    fun statistics(
        @Query("part") part: String?,
        @Query("id") id:String?,
        @Query("key") key: String?
    ): Call<VideoStats>
}