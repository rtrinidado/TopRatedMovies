package com.raultorinz.topratedmovies.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raultorinz.topratedmovies.R
import com.raultorinz.topratedmovies.adapter.RecyclerAdapter
import com.raultorinz.topratedmovies.model.MovieModel
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
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val topMovies : ArrayList<MovieModel> = ArrayList<MovieModel>()
        topMovies.add(MovieModel("Peli uno"))
        topMovies.add(MovieModel("Peli dos"))
        topMovies.add(MovieModel("Peli tres"))
        topMovies.add(MovieModel("Peli cuatro"))


        layoutManager = GridLayoutManager(context, 3)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(requireContext())
        adapter?.setMoviesList(topMovies)
        recyclerView.adapter = adapter
    }

}