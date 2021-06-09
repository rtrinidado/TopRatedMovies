package com.raultorinz.topratedmovies.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raultorinz.topratedmovies.data.api.ApiHelper
import com.raultorinz.topratedmovies.data.repository.MainRepository
import com.raultorinz.topratedmovies.ui.main.MainViewModel

class ViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Nombre de la clase desconocido")
    }
}