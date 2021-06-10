package com.raultorinz.topratedmovies.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raultorinz.topratedmovies.R
import com.raultorinz.topratedmovies.adapter.RecyclerAdapter
import com.raultorinz.topratedmovies.data.api.ApiHelper
import com.raultorinz.topratedmovies.data.api.RetrofitBuilder
import com.raultorinz.topratedmovies.ui.base.ViewModelFactory
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

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter

        viewModel.data.observe(viewLifecycleOwner, Observer {
                adapter?.setMoviesList(it.subList(0, 10))
        })

        viewModel.code.observe(viewLifecycleOwner, Observer {
            if (it == 200) {
                recyclerView.visibility = View.VISIBLE
                error.visibility = View.GONE
                title_main.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.GONE
                error.visibility = View.VISIBLE
                title_main.visibility = View.GONE
            }
        })
    }
}