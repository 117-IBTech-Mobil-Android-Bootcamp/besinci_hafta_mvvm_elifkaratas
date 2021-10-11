package com.example.week5.network.response

import com.example.week5.ui.filmlist.model.Popular
import com.google.gson.annotations.SerializedName

data class PopularMovieListResponse (
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages : Int,
    @SerializedName("results") val results : List<Popular>,
)