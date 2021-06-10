package com.raultorinz.topratedmovies.ui.details

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raultorinz.topratedmovies.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_details.*
import kotlinx.android.synthetic.main.details_fragment.*

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            var args = DetailsFragmentArgs.fromBundle(it)
            description_title.text = args.title
            original_title.text = args.originalTitle
            vote_average.text = args.voteAverage.toString()
            release_date.text = args.releaseDate
            overview.text = args.overview
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + args.posterPath).into(app_bar_image)

        }
    }
}