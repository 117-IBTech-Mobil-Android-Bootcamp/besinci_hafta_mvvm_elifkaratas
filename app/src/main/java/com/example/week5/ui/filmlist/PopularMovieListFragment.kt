package com.example.week5.ui.filmlist

import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week3.BaseRecyclerViewItemClickListener
import com.example.week5.R
import com.example.week5.base.BaseFragment
import com.example.week5.databinding.FragmentPopularMovieListBinding
import com.example.week5.ui.filmlist.adapter.PopularMoviesAdapter
import com.example.week5.ui.filmlist.model.Popular

class PopularMovieListFragment: BaseFragment<PopularMovieListViewModel, FragmentPopularMovieListBinding>() {
    override var viewModel: PopularMovieListViewModel?= null

    private val popularMovieList = mutableListOf<Popular>()
    private var adapter : PopularMoviesAdapter? = null

    override fun getLayoutID() = R.layout.fragment_popular_movie_list

    override fun prepareView() {
        adapter = PopularMoviesAdapter(popularMovieList, object :
            BaseRecyclerViewItemClickListener<Popular> {
            override fun onItemClicked(clickedObject: Popular, id: Int) {
                val bundle = bundleOf("id" to clickedObject.id.toString())
                findNavController().navigate(
                    R.id.action_popularMovieListFragment_to_movieDetailsFragment, bundle
                )
            }
        })

        dataBinding.recyclerView2.adapter = adapter

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(PopularMovieListViewModel::class.java)

    }

    override fun observeLiveData() {
        viewModel?.popularResponse?.observe(this, {

            dataBinding.popularMovieListResponse = it
            dataBinding.executePendingBindings()

            dataBinding.recyclerView2.adapter = PopularMoviesAdapter(it.getList())
        })
    }

    override fun shouldCheckInternetConnection() = false

    @BindingAdapter("poster_path")
    fun loadImage(view: ImageView, url: String) = Glide.with(view.context).load(url).into(view)


}