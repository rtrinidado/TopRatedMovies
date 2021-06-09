package com.raultorinz.topratedmovies.data.api

import com.raultorinz.topratedmovies.data.model.TopMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") key: String) : TopMovieResponse
}