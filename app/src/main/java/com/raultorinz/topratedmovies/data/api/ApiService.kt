package com.raultorinz.topratedmovies.data.api

import com.raultorinz.topratedmovies.data.model.TopMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/top_rated")
    suspend fun getTopTenMovies(@Query("api_key") key: String) : Response<TopMovieResponse>
}