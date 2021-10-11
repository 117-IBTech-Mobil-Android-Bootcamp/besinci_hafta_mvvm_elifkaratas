package com.example.week5.network
import com.example.week5.network.response.MovieDetailsResponse
import com.example.week5.network.response.PopularMovieListResponse
import retrofit2.Call
import retrofit2.http.*

interface MovieAPI {

    @GET("popular")
    fun getPopularMovies(@Query("api_key") apikey: String, @Query("page") page: Int
    ): Call<PopularMovieListResponse>

    @GET("{movie_id}")
    fun getMovieDetails(@Path("movie_id") id : String, @Query("api_key") apikey: String
    ): Call<MovieDetailsResponse>

}