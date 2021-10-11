package com.example.week5.ui.filmlist.model


import com.example.week5.network.response.PopularMovieListResponse

data class PopularMoviesViewStateModel (val popularMovieListResponse: PopularMovieListResponse)
{
    fun getTotalPages() : String = "Total Page: ${popularMovieListResponse.totalPages}"
    fun getTotalResults() : String = "Total Count: ${popularMovieListResponse.totalResults}"
    fun getList() : List<Popular> = popularMovieListResponse.results
}
