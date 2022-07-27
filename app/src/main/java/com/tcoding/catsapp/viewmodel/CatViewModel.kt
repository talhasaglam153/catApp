package com.tcoding.catsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcoding.catsapp.model.Cat
import com.tcoding.catsapp.model.CatInfo
import com.tcoding.catsapp.network.RetroInstance
import com.tcoding.catsapp.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await
import retrofit2.awaitResponse

class CatViewModel: ViewModel() {

    lateinit var catLiveData: MutableLiveData<Cat>

    init {
        catLiveData = MutableLiveData()
    }

    fun getLiveDataList(): MutableLiveData<Cat> {
        return catLiveData
    }

    fun callAPI() {

     GlobalScope.launch(Dispatchers.IO) {
         var api = RetroInstance.getRetroInstance().create(RetroService::class.java)
         var response = api.getCats().awaitResponse()

         if(response.isSuccessful) {
             var data = response.body()!!

             withContext(Dispatchers.Main) {
                 catLiveData.postValue(data)
             }

         }

     }


    }




}