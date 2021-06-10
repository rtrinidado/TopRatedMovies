package com.raultorinz.topratedmovies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.raultorinz.topratedmovies.R
import com.raultorinz.topratedmovies.data.model.MovieModel
import com.raultorinz.topratedmovies.ui.main.MainFragmentDirections
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_card_layout.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    private var movieList: List<MovieModel>? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieImg = itemView.movieImg
        var movieName = itemView.movieName
        var index : Int = 0

        init {
            itemView.setOnClickListener {
                val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(movieList!![index].title,
                    movieList!![index].original_title, movieList!![index].vote_average, movieList!![index].release_date,
                    movieList!![index].overview, movieList!![index].poster_path)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movieList.let {
            holder.movieName.text = it?.get(position)?.title ?: ""
            holder.index = position
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + it?.get(position)?.poster_path).into(holder.movieImg)
        }
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }

    fun setMoviesList (movies: List<MovieModel>) {
        movieList = movies
        notifyDataSetChanged()
    }
}