package com.example.week5.ui.filmlist.model

import com.example.week5.network.response.MovieDetailsResponse

data class MovieDetailsViewStateModel(val movieDetailResponse: MovieDetailsResponse){
    fun getId() : String = "${movieDetailResponse.id}"
    fun getBackdropPath() : String = "${movieDetailResponse.backdrop_path}"
    fun getOriginalTitle() : String = "${movieDetailResponse.original_title}"
    fun getVoteAverage() : String = "${movieDetailResponse.vote_average}"
    fun getVoteCount() : String = "${movieDetailResponse.vote_count}"
    fun getTagLine() : String = "${movieDetailResponse.tag_line}"
    fun getReleaseDate() : String = "${movieDetailResponse.release_date}"
    fun getList() : List<Detail> = movieDetailResponse.genres
}
