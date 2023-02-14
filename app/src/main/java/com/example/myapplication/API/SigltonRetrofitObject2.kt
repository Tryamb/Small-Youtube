package com.example.myapplication.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    class SingltonRetrofitObject2 private constructor() {
        init {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getAPI(): VID_API? {
            return retrofit.create(VID_API::class.java)
        }

        companion object {
            private var mInstance: SingltonRetrofitObject2? = null
            private const val BASE_URL = "https://www.googleapis.com/youtube/v3/"
            private lateinit var retrofit: Retrofit

            @Synchronized
            fun getmInstance(): SingltonRetrofitObject2? {
                if (mInstance == null) {
                    mInstance = SingltonRetrofitObject2()
                }
                return mInstance
            }
        }
    }
