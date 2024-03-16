package com.example.appup.Api

import android.widget.ImageView
import com.example.appup.Models.MyCountry
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryService {
    @GET("all")
    fun getAllCountryList(): Call<List<MyCountry>>
    @GET("name/{name}")
    fun getAllCountryUpdateList(@Query("name") name:String): Call<List<MyCountry>>
}
