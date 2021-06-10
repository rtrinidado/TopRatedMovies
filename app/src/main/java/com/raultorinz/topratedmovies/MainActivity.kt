package com.raultorinz.topratedmovies

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raultorinz.topratedmovies.ui.details.DetailsFragment

class MainActivity : AppCompatActivity(), DetailsFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onFragmentInteraction(uri: Uri) {}
}