package com.raultorinz.topratedmovies.data.repository

import com.raultorinz.topratedmovies.data.api.ApiHelper

class MainRepository(val apiHelper: ApiHelper) {
    suspend fun getTopTenMovies() = apiHelper.getTopTenMovies()
}