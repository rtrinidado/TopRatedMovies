package com.raultorinz.topratedmovies.data.api

class ApiHelper (private val apiService: ApiService) {
    suspend fun getTopRatedMovies() = apiService.getTopRatedMovies("82e5caf52eba41e5e5219d113a959f57")
}