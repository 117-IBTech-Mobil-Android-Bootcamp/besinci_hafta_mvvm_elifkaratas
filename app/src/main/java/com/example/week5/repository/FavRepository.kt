package com.example.week5.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.example.week5.network.response.AddFavResponse

class FavRepository {
    val onFavMoviesFetched = MutableLiveData<AddFavResponse>()

    fun getFavMovies(context: Context) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("MovieSharedPref", Context.MODE_PRIVATE)
        val list = AddFavResponse(sharedPreferences.all)
        onFavMoviesFetched.value = list
    }
}