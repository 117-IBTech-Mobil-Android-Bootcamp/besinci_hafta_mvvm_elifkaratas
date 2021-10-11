package com.example.week5.repository

import androidx.lifecycle.MutableLiveData
import com.example.week5.network.BaseCallBack
import com.example.week5.network.ServiceConnector
import com.example.week5.network.response.MovieDetailsResponse

class DetailRepository {
    val onMoviesFetched = MutableLiveData<MovieDetailsResponse>()
    fun getDetails(id : String, apiKey : String){
        ServiceConnector.restInterface.getMovieDetails(id,apiKey).enqueue(object  : BaseCallBack<MovieDetailsResponse>(){
            override fun onSuccess(data: MovieDetailsResponse) {
                onMoviesFetched.postValue(data)
            }
        })
    }
}