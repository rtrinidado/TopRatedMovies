package com.raultorinz.topratedmovies.ui.main

import androidx.lifecycle.ViewModel
import com.raultorinz.topratedmovies.data.model.MovieModel
import com.raultorinz.topratedmovies.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun getMoviesList():Deferred<List<MovieModel>?> =
        coroutineScope.async(Dispatchers.Default) {
            try {
                return@async mainRepository.getTopRatedMovies()
            } catch (exception: Exception) {
                return@async null
            }
        }
}