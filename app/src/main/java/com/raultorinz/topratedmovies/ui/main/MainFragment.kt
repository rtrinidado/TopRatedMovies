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
import com.raultorinz.topratedmovies.utils.Status
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerAdapter? = null

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
        adapter = RecyclerAdapter(ArrayList<MovieModel>())
        recyclerView.adapter = adapter

        viewModel.getTopRatedMovies().observe(viewLifecycleOwner, Observer {
            it?.let {
                resource ->
                when (resource.status) {
                    Status.SUCCESS -> resource.data?.let { response -> retrieveList(response)}
                    Status.ERROR -> Log.e("network", it.message!!)
                    Status.LOADING -> recyclerView.visibility = View.GONE
                }
            }
        })
    }

    private fun retrieveList(movies: List<MovieModel>) {
        adapter?.setMoviesList(movies)
    }

}