package com.raultorinz.topratedmovies.data.model

data class TopMovieResponse (
    var page: Long,
    var results: List<MovieModel>
) {}