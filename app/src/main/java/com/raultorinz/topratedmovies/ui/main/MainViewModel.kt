package com.raultorinz.topratedmovies.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raultorinz.topratedmovies.data.model.MovieModel
import com.raultorinz.topratedmovies.data.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val data = MutableLiveData<List<MovieModel>>()
    val code = MutableLiveData<Int>()

    init {
        getTopTenMovies()
    }

    private fun getTopTenMovies() {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val response = mainRepository.getTopTenMovies()
                code.postValue(response.code())
                if (response.isSuccessful && response.body() != null) {
                    data.postValue(response.body()!!.results)
                }
            } catch (e: Exception) {
                code.postValue(500)
            }
        }
    }
}