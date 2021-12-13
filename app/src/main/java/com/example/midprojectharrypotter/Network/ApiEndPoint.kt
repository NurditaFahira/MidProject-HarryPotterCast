package com.example.midprojectharrypotter.Network

import com.example.midprojectharrypotter.DataKarakter
import retrofit2.Call
import retrofit2.http.GET

interface api {

    @GET("api/characters")

    fun getDataKarakter() : Call<ArrayList<DataKarakter>>


}