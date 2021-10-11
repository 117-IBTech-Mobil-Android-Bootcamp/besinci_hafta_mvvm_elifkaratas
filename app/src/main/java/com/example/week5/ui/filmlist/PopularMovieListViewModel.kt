package com.example.week5.ui.filmlist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.week5.repository.PopularRepository
import com.example.week5.ui.filmlist.model.PopularMoviesViewStateModel
import com.patikadev.mvvmsample.util.API_KEY

class PopularMovieListViewModel : ViewModel() {

    val popularResponse = MediatorLiveData<PopularMoviesViewStateModel>()
    private val popularRepository = PopularRepository()

    init {
        popularRepository.getPopularMovies(API_KEY,2)

        popularResponse.addSource(popularRepository.onMoviesFetched) {
            popularResponse.value = PopularMoviesViewStateModel(it)
        }
    }
}