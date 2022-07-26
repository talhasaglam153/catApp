package com.tcoding.catsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcoding.catsapp.model.CatInfo
import com.tcoding.catsapp.network.RetroInstance
import com.tcoding.catsapp.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class CatViewModel: ViewModel() {

    lateinit var catLiveData: MutableLiveData<CatInfo>

    init {
        catLiveData = MutableLiveData()
    }

    fun getLiveDataList(): MutableLiveData<CatInfo> {
        return catLiveData
    }

    fun callAPI() {

     GlobalScope.launch(Dispatchers.IO) {
         var api = RetroInstance.getRetroInstance().create(RetroService::class.java)
         var response = api.getCats().let {
             if(it.isSuccessful) {
                 var data = it.body()!!

                 withContext(Dispatchers.Main) {
                     catLiveData.postValue(data)
                 }

             }
         }



     }


    }




}