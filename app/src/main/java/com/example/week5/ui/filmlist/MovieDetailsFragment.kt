package com.example.week5.ui.filmlist

import androidx.lifecycle.ViewModelProvider
import com.example.week5.R
import com.example.week5.base.BaseFragment
import com.example.week5.databinding.FragmentMovieDetailsBinding
import com.example.week5.ui.filmlist.adapter.MovieDetailsAdapter

class MovieDetailsFragment: BaseFragment<MovieDetailsViewModel, FragmentMovieDetailsBinding>() {
    override var viewModel: MovieDetailsViewModel?= null

    override fun getLayoutID() = R.layout.fragment_movie_details

    override fun prepareView() {
        //layoutmanager
        //orientation
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)

    }

    override fun observeLiveData() {
        viewModel?.movieDetailsResponse?.observe(this, {

            dataBinding.movieDetailsResponse = it
            dataBinding.executePendingBindings()

            dataBinding.recyclerView3.adapter = MovieDetailsAdapter(it.getList())
        })
    }
}