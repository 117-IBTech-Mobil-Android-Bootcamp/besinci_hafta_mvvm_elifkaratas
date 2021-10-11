package com.example.week5.ui.filmlist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.week5.repository.DetailRepository
import com.example.week5.ui.filmlist.model.MovieDetailsViewStateModel
import com.patikadev.mvvmsample.util.API_KEY

class MovieDetailsViewModel(val id:String): ViewModel() {
    val movieDetailsResponse = MediatorLiveData<MovieDetailsViewStateModel>()
    private val detailRepository = DetailRepository()

    init {
        detailRepository.getDetails(id,API_KEY)
        movieDetailsResponse.addSource(detailRepository.onMoviesFetched) {
            movieDetailsResponse.value = MovieDetailsViewStateModel(it)
        }
    }
}