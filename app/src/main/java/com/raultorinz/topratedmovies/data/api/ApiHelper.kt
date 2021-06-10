package com.raultorinz.topratedmovies.data.api

class ApiHelper (private val apiService: ApiService) {
    suspend fun getTopTenMovies() = apiService.getTopTenMovies("82e5caf52eba41e5e5219d113a959f57")
}