package com.max.ecomaxgo.maxpe.model.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.max.ecomaxgo.maxpe.config.retrofitconfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class WalletBalanceViewModel: ViewModel() {
    val factsLiveData: MutableLiveData<Login>


    init {
        factsLiveData = MutableLiveData()
    }
    fun getWallet(): LiveData<Login>{
        return factsLiveData

    }
    fun getWalletBalance(sKey: String, mob_number: String, userToken: String) {
        val call: Call<Login> =
            retrofitconfig.endpoints.getWalletBalance(sKey, mob_number, userToken)
        call.enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if (response.isSuccessful) {
                    factsLiveData.postValue(response.body())
                    System.out.println("factsLiveData---------------------" + factsLiveData.toString())
                }
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {

            }
        })
    }
}