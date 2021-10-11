package com.example.week5.network.response

import com.example.week5.ui.filmlist.model.Detail
import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("original_title") val original_title : String,
    @SerializedName("vote_average") val vote_average : Double,
    @SerializedName("vote_count") val vote_count : Int,
    @SerializedName("tag_line") val tag_line : String,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("genres") val genres : List<Detail>
 )