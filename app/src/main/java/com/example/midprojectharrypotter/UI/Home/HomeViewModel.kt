package com.example.midprojectharrypotter.UI.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.midprojectharrypotter.Adapter.HomeAdapter
import com.example.midprojectharrypotter.DataKarakter
import com.example.midprojectharrypotter.Network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel () {

    init {
        Log.d("HomeViewModel", "Created")
    }

    private val listKarakter = ArrayList<DataKarakter>()


    fun getDataFromApi(recyclerView: RecyclerView) {
        RetrofitClient.instance.getDataKarakter().enqueue(object : Callback<ArrayList<DataKarakter>> {
                override fun onResponse(call: Call<ArrayList<DataKarakter>>, response: Response<ArrayList<DataKarakter>>) {
                    Log.d("HomeViewModel", "Request")
                    if (response.isSuccessful) {

                        //val data = response.body()
                        recyclerView.adapter
                        response.body()?.let { listKarakter.addAll(it)
                            Log.d("HomeViewModel", "$it")
                        }

                        val adapter = HomeAdapter(listKarakter)
                        recyclerView.adapter = adapter
                        Log.d("HomeViewModel", "Init recycler view")
                    }
                }

                override fun onFailure(call: Call<ArrayList<DataKarakter>>, t: Throwable) {
                    Log.d("HomeViewModel", "HomeViewModel fun api Onfailure")

                }
            })


    }
}