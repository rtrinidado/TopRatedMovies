package com.raultorinz.topratedmovies.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.raultorinz.topratedmovies.data.repository.MainRepository
import com.raultorinz.topratedmovies.utils.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    fun getTopRatedMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getTopRatedMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Ocurrio un error"))
        }
    }
}