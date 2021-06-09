package com.raultorinz.topratedmovies.data.repository

import com.raultorinz.topratedmovies.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getTopRatedMovies() = apiHelper.getTopRatedMovies().results
}