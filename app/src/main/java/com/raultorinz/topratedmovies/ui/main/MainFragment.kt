package com.raultorinz.topratedmovies.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raultorinz.topratedmovies.R
import com.raultorinz.topratedmovies.adapter.RecyclerAdapter
import com.raultorinz.topratedmovies.data.api.ApiHelper
import com.raultorinz.topratedmovies.data.api.RetrofitBuilder
import com.raultorinz.topratedmovies.data.model.MovieModel
import com.raultorinz.topratedmovies.ui.base.ViewModelFactory
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerAdapter? = null
    var topMovies : ArrayList<MovieModel>? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).get(MainViewModel::class.java)

        layoutManager = GridLayoutManager(context, 3)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter

        CoroutineScope(Dispatchers.Main).launch {
            val result : List<MovieModel>? = viewModel.getMoviesList().await()
            if (result != null)
                retrieveList(result)
        }
    }

    private fun retrieveList(movies: List<MovieModel>) {
        adapter?.setMoviesList(movies)
    }

}