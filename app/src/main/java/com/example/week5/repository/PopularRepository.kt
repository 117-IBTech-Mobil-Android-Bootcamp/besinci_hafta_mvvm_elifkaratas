package com.example.week5.repository

import androidx.lifecycle.MutableLiveData
import com.example.week5.network.BaseCallBack
import com.example.week5.network.ServiceConnector
import com.example.week5.network.response.PopularMovieListResponse

class PopularRepository {
    val onMoviesFetched = MutableLiveData<PopularMovieListResponse>()

    fun getPopularMovies(apiKey : String, page : Int){
        ServiceConnector.restInterface.getPopularMovies(apiKey,page).enqueue(object  : BaseCallBack<PopularMovieListResponse>(){
            override fun onSuccess(data: PopularMovieListResponse) {
                onMoviesFetched.postValue(data)
            }
        })
    }
}