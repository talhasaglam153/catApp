package com.tcoding.catsapp.network

import com.tcoding.catsapp.model.Cat
import com.tcoding.catsapp.model.CatInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetroService {


    @GET("v1/breeds")
    fun getCats(): Call<Cat>

}