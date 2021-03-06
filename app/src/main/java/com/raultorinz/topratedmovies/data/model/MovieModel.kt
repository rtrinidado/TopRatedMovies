package com.raultorinz.topratedmovies.data.model

data class MovieModel (
    var adult: Boolean,
    var backdrop_path: String?,
    var genre_ids: List<Int>?,
    var id: Int,
    var original_language: String?,
    var original_title: String?,
    var overview: String?,
    var popularity: Float,
    var poster_path: String?,
    var release_date: String?,
    val title: String?,
    var video: Boolean,
    var vote_average: Float,
    var vote_count: Int
) {}